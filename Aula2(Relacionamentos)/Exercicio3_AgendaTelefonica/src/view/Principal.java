package view;

import model.AgendaTelefonica;
import model.Contato;

public class Principal {

	public static void main(String[] args) {
		AgendaTelefonica agenda = new AgendaTelefonica();
		
		Contato contato1 = new Contato();
		
		contato1.setNome("Joaozinho");
		contato1.setTelefone(969874512);
		contato1.setEmail("joao_zinho@email.com");
		
		Contato contato2 = new Contato();
		
		contato2.setNome("Maria");
		contato2.setTelefone(954870123);
		contato2.setEmail("maria_bonita@email.com");
		
		
		Contato contato3 = new Contato();
		
		contato3.setNome("Paulo");
		contato3.setTelefone(965893201);
		contato3.setEmail("paulinho_gameplays@email.com");
		
		
		Contato contato4 = new Contato();
		
		contato4.setNome("Ana");
		contato4.setTelefone(923458976);
		contato4.setEmail("ana_banana@email.com");
		
		
		agenda.adicionarContato(contato1);
		agenda.adicionarContato(contato2);
		agenda.adicionarContato(contato3);
		
		agenda.buscarContato(923458976); //buscando contato fora da lista
		agenda.buscarContato(954870123); //buscando contato dentro da lista
		
		agenda.removeContato(965893201); // removendo contato
		agenda.buscarContato(965893201); //buscando contato removido
	}

}
