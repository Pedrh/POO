package model;

public class Animal {
	private String nome;
	private int comprimento;
	private int patas;
	private String cor;
	private String ambiente;
	private float velocidade;
	
	
	public Animal() {
		super();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}


	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}


	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}


	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}
	
	
	public void alteraNome(String nome) {
		setNome(nome);
	}
	
	public void alteraComprimento(int comprimento) {
		setComprimento(comprimento);
	}
	
	public void alteraPatas(int patas) {
		setPatas(patas);
	}
	
	public void alteraCor(String cor) {
		setCor(cor);
	}
	
	public void alteraAmbiente(String ambiente) {
		setAmbiente(ambiente);
	}
	
	public void alteraVelocidade(float velocidade) {
		setVelocidade(velocidade);
	}
	
	public void dados() {
		System.out.println("Animal: " + nome + "\rComprimento: " + comprimento + "cm \rPatas: " + patas + "\rCor: " + cor
				+ "\rHabitat: " + ambiente + "\rVelocidade: " + velocidade + "m/s");
	}


}
