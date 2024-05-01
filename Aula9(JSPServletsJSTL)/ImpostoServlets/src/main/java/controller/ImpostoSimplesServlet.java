package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ImpostoBeloHorizonte;
import model.ImpostoSaoPaulo;

import java.io.IOException;

@WebServlet("/impostossimples")
public class ImpostoSimplesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImpostoSimplesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		String areaTotal = request.getParameter("areaTotal");
		
		
		String saida = "";
		if(cmd.equals("Calcular SP")) {
			String numComodos = request.getParameter("numComodos");
			ImpostoSaoPaulo imposto = new ImpostoSaoPaulo();
			
			imposto.setAreaTotal(Float.parseFloat(areaTotal));
			imposto.setNumComodos(Integer.parseInt(numComodos));
			imposto.calcularImposto();
			
			saida = imposto.toString();
			request.setAttribute("saida", saida);
		} else {
			String numQuartos = request.getParameter("numQuartos");
			ImpostoBeloHorizonte imposto = new ImpostoBeloHorizonte();
			
			imposto.setAreaTotal(Float.parseFloat(areaTotal));
			imposto.setNumQuartos(Integer.parseInt(numQuartos));
			imposto.calcularImposto();
			
			saida = imposto.toString();
			request.setAttribute("saida", saida);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}