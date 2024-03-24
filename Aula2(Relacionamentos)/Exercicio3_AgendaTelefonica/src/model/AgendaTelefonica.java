package model;

import fateczl.Lista.model.Lista;

public class AgendaTelefonica {
	private Lista<Contato> contatos;
	
	public AgendaTelefonica() {
		super();
		contatos = new Lista<>();
	}
	
	public Lista<Contato> getAgendaTelefonica() {
		return this.contatos;
	}
	
	public void adicionarContato(Contato contatoNovo) {
		try {
			contatos.addLast(contatoNovo);
			System.out.println("Contato adicionado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeContato(long telefone) {
		int tamanho = contatos.size();
		boolean remocao = false;
		for(int i = 0; i < tamanho; i++) {
			try {
				Contato contatoAtual = contatos.get(i);
				if(telefone == contatoAtual.getTelefone()) {
					contatos.remove(i);
					remocao = true;
					System.out.println("Contato " + contatoAtual.getNome() +" removido");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!remocao) {
			System.err.println("Contato não encontrado");
		}
	}
	
	public void buscarContato(long telefone) {
		int tamanho = contatos.size();
		boolean busca = false;
		for(int i = 0; i < tamanho; i++) {
			try {
				Contato contatoAtual = contatos.get(i);
				if(telefone == contatoAtual.getTelefone()) {
					System.out.println("-----------------------");
					System.out.println("Contato encontrado: \r" + contatoAtual.getNome() + "(" + contatoAtual.getTelefone() + ") - " + contatoAtual.getEmail());
					System.out.println("-----------------------");
					busca = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!busca) {
			System.err.println("Contato não encontrado");
		}
	}
}
