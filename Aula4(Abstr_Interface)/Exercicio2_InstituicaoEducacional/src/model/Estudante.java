package model;

public abstract class Estudante {
	private String nome;
	private String ra;
	private String email;
	private float mediaNotas;
	private String qtdAprovacoes;
	
	public Estudante() {
		super();
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getMediaNotas() {
		return mediaNotas;
	}

	public void setMediaNotas(float mediaNotas) {
		this.mediaNotas = mediaNotas;
	}

	public int getQtdAprovacoes() {
		return Integer.parseInt(qtdAprovacoes);
	}

	public void setQtdAprovacoes(String qtdAprovacoes) {
		this.qtdAprovacoes = qtdAprovacoes;
	}
	
	
}
