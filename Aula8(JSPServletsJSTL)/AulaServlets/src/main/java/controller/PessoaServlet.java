package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pessoa> pessoas;
       
    public PessoaServlet() {
    	pessoas = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pessoas", pessoas); // ao inves de só voltar para a página de cadastro, já entra nela listando as pessoas
		
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp"); //sem isso, ele deixa a tela em branco. Para o get em especifico, é como colar a url do /pessoa
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar"); //recebe o name declarado dos inputs no cadastro.jsp
		String nome = request.getParameter("nome");
		String id = request.getParameter("id");
		String dataNasc = request.getParameter("dataNasc");
		
		String saida = "";
		
		if(cmd.equals("Enviar")) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(Integer.parseInt(id));
			pessoa.setNome(nome);
			pessoa.setDataNasc(LocalDate.parse(dataNasc));
			
			pessoas.add(pessoa);
			saida = "Pessoa cadastrada";
			request.setAttribute("saida", saida); // essa mensagem marca o retorno da acao
		} else {
			request.setAttribute("pessoas", pessoas);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp"); //devolve para o cadastro.jsp despachando a mensagem declarada no setAtribute
		rd.forward(request, response);
	}

}
