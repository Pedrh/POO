package view;

import model.Funcionario;

public class Principal {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Joyce");
		funcionario.setCargo("Assistente");
		funcionario.setSalario(1200.00d);
		
		System.out.println(funcionario.getNome() + " - " + funcionario.getCargo() + "| Salario Bruto: " + funcionario.getSalario() + ":\n");
		funcionario.getSalarioLiquido(100, 500);
		
		Funcionario funcionario2 = new Funcionario();
		
		funcionario2.setNome("Jair");
		funcionario2.setCargo("Diretor");
		funcionario2.setSalario(2000.00d);
		
		System.out.println(funcionario2.getNome() + " - " + funcionario2.getCargo() + "| Salario Bruto: " + funcionario2.getSalario() + ":\n");
		funcionario2.getSalarioLiquido(1400, 250);		
	}

}
