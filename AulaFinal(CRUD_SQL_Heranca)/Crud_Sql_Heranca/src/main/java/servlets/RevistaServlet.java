package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.RevistaController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Revista;

@WebServlet("/revista")
public class RevistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RevistaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("revista.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String qtdPaginas = request.getParameter("qtdPaginas");
		String issn = request.getParameter("issn");
		RevistaController rc = new RevistaController();

		// Retorno
		String saida = "";
		String erro = "";
		Revista r = new Revista();
		List<Revista> revistas = new ArrayList<>();

		// geracao da revista atual para manipulacao
		Revista revista = new Revista();

		if(!cmd.contains("Consultar")) {
			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				revista = rc.createRevista(Integer.parseInt(codigo), nome, Integer.parseInt(qtdPaginas), issn);
			} else {
				revista.setCodigo(Integer.parseInt(codigo));
			}
		}

		try {
			if (cmd.contains("Cadastrar")) {
				rc.insert(revista);
				saida = "Revista cadastrada com sucesso";
				revista = null;
			} 
			if(cmd.contains("Alterar")) {
				rc.update(revista);
				saida = "Revista alterada com sucesso";
				revista = null;
			}
			if (cmd.contains("Excluir")) {
				rc.delete(revista);
				saida = "Revista excluida com sucesso";
				revista = null;
			}
			if (cmd.contains("Buscar")) {
				r = rc.findOne(revista);
				revista = null;
			}
			if (cmd.contains("Consultar")) {
				revistas = rc.findAll();
				revista = null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("revista", r);
			request.setAttribute("revistas", revistas);

			RequestDispatcher rd = request.getRequestDispatcher("revista.jsp");
			rd.forward(request, response);
		}

	}

}
