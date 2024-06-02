package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.LivroController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Livro;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("livro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String qtdPaginas = request.getParameter("qtdPaginas");
		String isbn = request.getParameter("isbn");
		String edicao = request.getParameter("edicao");
		LivroController lc = new LivroController();

		// Retorno
		String saida = "";
		String erro = "";
		Livro l = new Livro();
		List<Livro> livros = new ArrayList<>();

		// geracao do livro atual para manipulacao
		Livro livro = new Livro();

		if (!cmd.contains("Consultar")) {
			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				livro = lc.createLivro(Integer.parseInt(codigo), nome, Integer.parseInt(qtdPaginas), isbn,
						Integer.parseInt(edicao));
			} else {
				livro.setCodigo(Integer.parseInt(codigo));
			}
		}

		try {
			if (cmd.contains("Cadastrar")) {
				lc.insert(livro);
				saida = "Livro cadastrado com sucesso";
				livro = null;
			}
			if (cmd.contains("Alterar")) {
				lc.update(livro);
				saida = "Livro alterado com sucesso";
				livro = null;
			}

			if (cmd.contains("Excluir")) {
				lc.delete(livro);
				saida = "Livro excluido com sucesso";
				livro = null;
			}
			if (cmd.contains("Buscar")) {
				l = lc.findOne(livro);
				livro = null;
			}
			if (cmd.contains("Consultar")) {
				livros = lc.findAll();
				livro = null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("livro", l);
			request.setAttribute("livros", livros);

			RequestDispatcher rd = request.getRequestDispatcher("livro.jsp");
			rd.forward(request, response);
		}

	}

}
