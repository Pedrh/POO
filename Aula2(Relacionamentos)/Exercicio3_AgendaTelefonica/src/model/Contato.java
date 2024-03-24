package model;

public class Contato {
	
	private String nome;
	private long telefone;
	private String email;
	
	
	public Contato() {
		super();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public long getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
