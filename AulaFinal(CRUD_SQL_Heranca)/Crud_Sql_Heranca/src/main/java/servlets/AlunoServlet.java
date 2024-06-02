package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.AlunoController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Entrada
		String cmd = request.getParameter("botao");
		String ra = request.getParameter("ra");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		AlunoController ac = new AlunoController();

		// Retorno
		String saida = "";
		String erro = "";
		Aluno a = new Aluno();
		List<Aluno> alunos = new ArrayList<>();

		Aluno aluno = new Aluno();

		if (!cmd.contains("Consultar")) {
			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				aluno = ac.createAluno(Integer.parseInt(ra), nome, email);
			} else {
				aluno.setRa(Integer.parseInt(ra));
			}
		}

		try {

			if (cmd.contains("Cadastrar")) {
				ac.insert(aluno);
				saida = "Aluno cadastrado com sucesso";
				aluno = null;
			}
			if(cmd.contains("Alterar")){
				ac.update(aluno);
				saida = "Aluno alterado com sucesso";
				aluno = null;
			}

			if (cmd.contains("Excluir")) {
				ac.delete(aluno);
				saida = "Aluno excluido com sucesso";
				aluno = null;
			}
			if (cmd.contains("Buscar")) {
				a = ac.findOne(aluno);
				aluno = null;
			}
			if (cmd.contains("Consultar")) {
				alunos = ac.findAll();
				aluno = null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("aluno", a);
			request.setAttribute("alunos", alunos);

			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			rd.forward(request, response);
		}
	}

}
