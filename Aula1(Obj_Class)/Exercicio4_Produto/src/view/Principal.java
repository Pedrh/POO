package view;

import model.Produto;

public class Principal {

	public static void main(String[] args) {

		Produto produto = new  Produto();
		Produto produto2 = new  Produto();
		
		produto.setNome("Chocolate");
		produto.setPreco(3);
		produto.setQtdEstoque(1000);
		
		produto2.setNome("Shampoo");
		produto2.setPreco(12);
		produto2.setQtdEstoque(-5);
		
		
		produto.verificaProdutoDisponivel(produto.getNome());
		System.out.println("O valor total do estoque atual e: " + produto.totalValorEstoque());
		
		produto2.verificaProdutoDisponivel(produto2.getNome());
		System.out.println("O valor total do estoque atual e: " + produto2.totalValorEstoque());
	}

}
