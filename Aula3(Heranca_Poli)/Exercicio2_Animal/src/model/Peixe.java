package model;

public class Peixe extends Animal {
	private String caracteristica;
	
	public Peixe() {
		super();
	}
	
	public String getCaracteristica() {
		return this.caracteristica;
	}
	
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	public void alteraCaracteristica(String caracteristica) {
		setCaracteristica(caracteristica);
	}
	
	public String caracteristica() {
		return this.caracteristica;
	}
	
	@Override
	public void dados() {
		System.out.println("Nome: " + getNome() + "\rCaracteristica: " + caracteristica);
	}
}
