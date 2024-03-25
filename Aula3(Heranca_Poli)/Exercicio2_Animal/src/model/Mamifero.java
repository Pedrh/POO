package model;

public class Mamifero extends Animal {
	private String alimento;
	
	public Mamifero() {
		super();
	}
	
	public String getAlimento() {
		return this.alimento;
	}
	
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	
	public void alterAlimento(String alimento) {
		setAlimento(alimento);
	}
	
	public String alimento(){
		return alimento;
	}
	
	@Override
	public void dados() {
		System.out.println("Nome: " + getNome() + "\rAlimento: " + alimento);
	}
}
