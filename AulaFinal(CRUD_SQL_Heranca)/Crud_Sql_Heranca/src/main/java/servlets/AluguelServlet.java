package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.AluguelController;
import controller.AlunoController;
import controller.ExemplarController;
import controller.LivroController;
import controller.RevistaController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluguel;
import model.Aluno;
import model.Exemplar;
import model.Livro;
import model.Revista;

 @WebServlet("/aluguel")
public class AluguelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public AluguelServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		List<Aluno> alunos = new ArrayList<>();
		List<Exemplar> exemplares = new ArrayList<>();
		
		AlunoController ac = new AlunoController();
		ExemplarController ec = new ExemplarController();
		
		try {
			alunos = ac.findAll();
			exemplares =  ec.juntaExemplares();
		}catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			request.setAttribute("alunos", alunos);
			request.setAttribute("exemplares", exemplares);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("aluguel.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Entrada
		String cmd = request.getParameter("botao");
		String aluno = request.getParameter("aluno");
		String exemplar = request.getParameter("exemplar");
		String dataRetirada = request.getParameter("dataRetirada");
		String dataDevolucao = request.getParameter("dataDevolucao");
		AluguelController ac = new AluguelController();
		AlunoController alc = new AlunoController();
		ExemplarController ec = new ExemplarController();

		// Retorno
		String saida = "";
		String erro = "";
		Aluguel aluguel = new Aluguel();
		List<Aluno> alunos = new ArrayList<>();
		List<Exemplar> exemplares = new ArrayList<>();
		List<Aluguel> alugueis = new ArrayList<>();

		
		if (!cmd.contains("Listar")) {
			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				try {
					alunos = alc.findAll();
					exemplares = ec.juntaExemplares();
					
					Aluno al = new Aluno();
					al.setRa(Integer.parseInt(aluno));
					al = alc.findOne(al);
					
					Exemplar ex = new Revista();
					ex.setCodigo(Integer.parseInt(exemplar));
					String tipoExemplar = ec.especificaExemplar(ex);
					
					if(tipoExemplar.contains("livro")) {
						LivroController lc = new LivroController();
						Livro l = new Livro();
						l.setCodigo(ex.getCodigo());
						ex = lc.findOne(l);
					} else if(tipoExemplar.contains("revista")){
						RevistaController rc = new RevistaController();
						Revista r = new Revista();
						r.setCodigo(ex.getCodigo());
						ex = rc.findOne(r);
					} else {
						ex = null;
					}
					
					aluguel = ac.createAluguel(al, ex, LocalDate.parse(dataRetirada), LocalDate.parse(dataDevolucao));
				} catch (SQLException | ClassNotFoundException e) {
					erro = e.getMessage();
				}
			} else {
				aluguel.setDataRetirada(LocalDate.parse(dataRetirada));
			}
		}

		try {
			alunos = alc.findAll();
			exemplares = ec.juntaExemplares();
			
			if (cmd.contains("Cadastrar")) {
				ac.insert(aluguel);
				saida = "Aluguel criado com sucesso";
				aluguel = null;
			}
			if(cmd.contains("Alterar")){
				ac.update(aluguel);
				saida = "Aluguel atualizado com sucesso";
				aluguel = null;
			}

			if (cmd.contains("Excluir")) {
				ac.delete(aluguel);
				saida = "Aluguel excluido com sucesso";
				aluguel = null;
			}
			if (cmd.contains("Buscar")) {
				aluguel = ac.findOne(aluguel);
			}
			if (cmd.contains("Listar")) {
				alugueis = ac.findAll();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("aluguel", aluguel);
			request.setAttribute("alugueis", alugueis);
			request.setAttribute("alunos", alunos);
			request.setAttribute("exemplares", exemplares);

			RequestDispatcher rd = request.getRequestDispatcher("aluguel.jsp");
			rd.forward(request, response);
		}

	}

}
