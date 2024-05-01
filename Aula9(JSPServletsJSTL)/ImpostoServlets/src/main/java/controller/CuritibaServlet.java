package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ImpostoCuritiba;

import java.io.IOException;

@WebServlet("/curitiba")
public class CuritibaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CuritibaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String areaTotal = request.getParameter("areaTotal");
		String idadeImovel = request.getParameter("idadeImovel");
		String saida = "";
		
		ImpostoCuritiba imposto = new ImpostoCuritiba();
		
		imposto.setAreaTotal(Float.parseFloat(areaTotal));
		imposto.setIdadeImovel(Integer.parseInt(idadeImovel));
		imposto.calcularImposto();
		
		saida = imposto.toString();
		request.setAttribute("saida", saida);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
