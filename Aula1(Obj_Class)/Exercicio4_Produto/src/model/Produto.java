package model;

public class Produto {

	private String nome;
	private float preco;
	private int qtdEstoque;
	
	
	public Produto() {
		super();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public float getPreco() {
		return this.preco;
	}
	
	public void setPreco(float preco) {
		if(preco < 0 ) {
			this.preco = 0;
		}else {
			this.preco = preco;
		}
	}
	
	
	public int getQtdEstoque() {
		return this.qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque) {
		if(qtdEstoque < 0 ) {
			this.qtdEstoque = 0;
		}else {
			this.qtdEstoque = qtdEstoque;
		}
	}
	
	
	public boolean verificaProdutoDisponivel(String nome) {
		if(qtdEstoque == 0) {
			System.out.println("O produto " + nome + " não esta disponivel");
			return false;
		}else {
			System.out.println("O produto " + nome + " esta disponivel");
			return true;
		}
	}
	
	public float totalValorEstoque() {
		float total = preco * qtdEstoque;
		return total;
	}
}
