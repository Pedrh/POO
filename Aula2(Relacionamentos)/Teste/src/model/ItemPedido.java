package model;

public class ItemPedido {
	
	private int quantidade;
	private String nome;
	
	
	public ItemPedido() {
		super();
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade < 0) {
			this.quantidade = 0;
		} else {
			this.quantidade = quantidade;
		}
	}
	
}