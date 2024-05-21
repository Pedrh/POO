package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Time;
import persistence.GenericDao;
import persistence.TimeDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("time.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");
		
		//Retorno
		String saida = "";
		String erro = "";
		Time t = new Time();
		List<Time> times= new ArrayList<>();
		
		if(!cmd.contains("Consultar")) {
			t.setCodigo(Integer.parseInt(codigo));
		}
		if(cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
			t.setNome(nome);
			t.setCidade(cidade);
		}
		try {
			if(cmd.contains("Cadastrar")) {
				cadastrarTime(t);
				saida = "Time cadastrado com sucesso";
				t = null;
			} 
			if(cmd.contains("Alterar")) {
				alterarTime(t);
				saida = "Time alterado com sucesso";
				t = null;
			} 
			if(cmd.contains("Excluir")) {
				excluirTime(t);
				saida = "Time excluido com sucesso";
				t = null;
			}
			if(cmd.contains("Buscar")) {
				t = buscarTime(t);
			} 
			if(cmd.contains("Consultar")){
				times = listarTimes();
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("time", t);
			request.setAttribute("times", times);
			
			RequestDispatcher rd = request.getRequestDispatcher("time.jsp");
			rd.forward(request, response);
		}
	}

	

	private void cadastrarTime(Time t) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		TimeDao tDao = new TimeDao(gDao);
		tDao.inserir(t);
	}

	private void alterarTime(Time t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		TimeDao tDao = new TimeDao(gDao);
		tDao.atualizar(t);
	}

	private void excluirTime(Time t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		TimeDao tDao = new TimeDao(gDao);
		tDao.excluir(t);
	}

	private Time buscarTime(Time t) throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		TimeDao tDao = new TimeDao(gDao);
		t = tDao.consultar(t);
		return t;
	}

	private List<Time> listarTimes() throws SQLException, ClassNotFoundException{
		GenericDao gDao = new GenericDao();
		TimeDao tDao = new TimeDao(gDao);
		List<Time> times = tDao.listar();
		return times;
	}
}
