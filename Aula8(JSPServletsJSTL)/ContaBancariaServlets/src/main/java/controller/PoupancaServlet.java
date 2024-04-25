package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaPoupanca;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/poupanca")
public class PoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<ContaPoupanca> contas;
	
    public PoupancaServlet() {
    	contas = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("contaPoupanca.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		String nome = request.getParameter("nome");
		String numConta = request.getParameter("numConta");
		String rendimentoDia = request.getParameter("rendimentoDia");
		String saldo = request.getParameter("saldo");
		String posicao = request.getParameter("posicao");
		
		String saida = "";
		if(cmd.equals("Enviar")) {
			ContaPoupanca conta = new ContaPoupanca();
			conta.setCliente(nome);
			conta.setNumConta(Integer.parseInt(numConta));
			conta.setDiaRendimento(Integer.parseInt(rendimentoDia));
			conta.setSaldo(Integer.parseInt(saldo));
			
			contas.add(conta);
			saida = "Conta cadastrada";
			request.setAttribute("saida", saida);
		} else if(cmd.equals("Encontrar")) {
			try {
				ContaPoupanca contaEncontrada = contas.get(Integer.parseInt(posicao));
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
				ContaPoupanca contaSaque = contas.get(Integer.parseInt(posicao));
				contaSaque.sacar(Float.parseFloat(valorSaque));
				saida = contaSaque.toString();
				request.setAttribute("saida", saida);
			}catch(ArithmeticException e) {
				saida = e.getMessage();
				request.setAttribute("saida", saida);
			}
		} else if(cmd.equals("Depositar")) {
			String valorDep = request.getParameter("valorDep");
			ContaPoupanca contaDep = contas.get(Integer.parseInt(posicao));
			contaDep.depositar(Float.parseFloat(valorDep));
			saida = contaDep.toString();
			request.setAttribute("saida", saida);
		} else {
			ContaPoupanca contaCalculo = contas.get(Integer.parseInt(posicao));
//			int rendimento = Integer.parseInt(rendimentoDia);
//			float taxaRendimento =  rendimento / 100f;
			contaCalculo.calcularNovoSaldo(contaCalculo.getDiaRendimento());
			saida = contaCalculo.toString();
			request.setAttribute("saida", saida);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("contaPoupanca.jsp");
		rd.forward(request, response);
	}

}
