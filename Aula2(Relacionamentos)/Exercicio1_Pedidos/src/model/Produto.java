package model;

public class Produto {
	private int codigo;
	private double valor;
	private String descricao;
	
	public Produto() {
		super();
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		if(valor < 0) {
			this.valor = 0;
		} else {
			this.valor = valor;
		}
	}
	
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
