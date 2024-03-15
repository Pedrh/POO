package view;

import model.Pessoa;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		Pessoa pessoa3 = new Pessoa();
		
		
		pessoa1.setNome("Sandra");
		pessoa1.setProfissao("Agiota");
		pessoa1.setDataNascimento(14, 03, 2024);
		
		System.out.println(pessoa1.getNome() + ", " + pessoa1.getProfissao() + " | " + pessoa1.getDataNascimento());
		pessoa1.getIdade();
		
		pessoa2.setNome("Anderson");
		pessoa2.setProfissao("Monge");
		pessoa2.setDataNascimento(05, 06, 1845);
		
		System.out.println(pessoa2.getNome() + ", " + pessoa2.getProfissao() + " | " + pessoa2.getDataNascimento());
		pessoa2.getIdade();
		
		pessoa3.setNome("Clovis");
		pessoa3.setProfissao("Faxineiro");
		pessoa3.setDataNascimento(02, 10, 1977);
		
		System.out.println(pessoa3.getNome() + ", " + pessoa3.getProfissao() + " | " + pessoa3.getDataNascimento());
		pessoa3.getIdade();
		
	}

}
