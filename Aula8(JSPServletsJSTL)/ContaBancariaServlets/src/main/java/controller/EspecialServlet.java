package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/especial")
public class EspecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<ContaEspecial> contas;
	
    public EspecialServlet() {
    	contas = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("contaEspecial.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		String nome = request.getParameter("nome");
		String numConta = request.getParameter("numConta");
		String limite = request.getParameter("limite");
		String saldo = request.getParameter("saldo");
		String posicao = request.getParameter("posicao");
		
		String saida = "";
		if(cmd.equals("Enviar")){
			ContaEspecial conta = new ContaEspecial();
			conta.setCliente(nome);
			conta.setNumConta(Integer.parseInt(numConta));
			conta.setLimite(Float.parseFloat(limite));
			conta.setSaldo(Integer.parseInt(saldo));
			
			contas.add(conta);
			saida = "Conta cadastrada";
			request.setAttribute("saida", saida);
		}else if(cmd.equals("Encontrar")) {
			try {
				ContaEspecial contaEncontrada = contas.get(Integer.parseInt(posicao));
				saida = contaEncontrada.toString();
				request.setAttribute("saida", saida);
			}
			catch (Exception e){
				saida = "Conta não encontrada";
				request.setAttribute("saida", saida);
			}
		} else if(cmd.equals("Sacar")) {
			String valorSaque = request.getParameter("valorSaque");
			try {
				ContaEspecial contaSaque = contas.get(Integer.parseInt(posicao));
				contaSaque.sacar(Float.parseFloat(valorSaque));
				saida = contaSaque.toString();
				request.setAttribute("saida", saida);
			}catch(ArithmeticException e) {
				saida = e.getMessage();
				request.setAttribute("saida", saida);
			}
		} else{
			String valorDep = request.getParameter("valorDep");
			ContaEspecial contaDep = contas.get(Integer.parseInt(posicao));
			contaDep.depositar(Float.parseFloat(valorDep));
			saida = contaDep.toString();
			request.setAttribute("saida", saida);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("contaEspecial.jsp");
		rd.forward(request, response);
	}

}
