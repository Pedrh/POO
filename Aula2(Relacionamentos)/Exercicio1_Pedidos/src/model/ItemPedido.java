package model;

public class ItemPedido {
	
	private int quantidade;
	private Produto produto;
	
	
	public ItemPedido() {
		super();
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade < 0) {
			this.quantidade = 0;
		} else {
			this.quantidade = quantidade;
		}
	}
	
}
