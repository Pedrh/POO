package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ImpostoPortoAlegre;

import java.io.IOException;

@WebServlet("/portoalegre")
public class PortoAlegreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortoAlegreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String areaTotal = request.getParameter("areaTotal");
		String garagem = request.getParameter("garagem");
		String areaGaragem = request.getParameter("areaGaragem");
		
		String saida = "";
		
		ImpostoPortoAlegre imposto = new ImpostoPortoAlegre();
		
		imposto.setAreaTotal(Float.parseFloat(areaTotal));
		if(garagem == null) {
			garagem = "Não";
		}
		imposto.setGaragem(garagem.toString());
		imposto.setAreaGaragem(Float.parseFloat(areaGaragem));
		
		imposto.calcularImposto();
		
		saida = imposto.toString();
		request.setAttribute("saida", saida);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
