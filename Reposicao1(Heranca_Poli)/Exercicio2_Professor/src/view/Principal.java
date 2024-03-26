package view;

import model.Professor;
import model.ProfessorHorista;
import model.ProfessorTitular;

public class Principal {

	public static void main(String[] args) {
		Professor professor = new Professor();
		
		professor.setNome("leandro");
		professor.setMatricula("123456");
		professor.setIdade(38);
		
		ProfessorHorista professorH = new ProfessorHorista();
		
		professorH.setNome("Anderson");
		professorH.setMatricula("234567");
		professorH.setIdade(36);
		professorH.setHorasAula(200);
		professorH.setValorHoraAula(30);
		
		
		ProfessorTitular professorT = new ProfessorTitular();
		
		professorT.setNome("Geane");
		professorT.setMatricula("345678");
		professorT.setIdade(50);
		professorT.setAnosInstituicao(4);
		professorT.setSalario(3500d);
		
		
		professorH.calcSalario();
		System.out.println("Salario titular: R$" + professorT.getSalario());
	}

}
