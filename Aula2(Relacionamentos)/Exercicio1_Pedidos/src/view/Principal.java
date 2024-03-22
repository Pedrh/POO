package view;

import model.ItemPedido;
import model.Pedido;
import model.Produto;

public class Principal {

	public static void main(String[] args) {
		Produto produto1 = new Produto();
		
		produto1.setCodigo(12);
		produto1.setDescricao("Barra de chocolate");
		produto1.setValor(8.00);

		Produto produto2 = new Produto();
		
		produto2.setCodigo(04);
		produto2.setDescricao("Bola");
		produto2.setValor(12.00);
		
		Produto produto3 = new Produto();
		
		produto3.setCodigo(53);
		produto3.setDescricao("Caderno");
		produto3.setValor(35.00);
		
		
		
		ItemPedido item1 = new ItemPedido();
		
		item1.setProduto(produto2);
		item1.setQuantidade(5);
		
		
		ItemPedido item2 = new ItemPedido();
		
		item2.setProduto(produto1);
		item2.setQuantidade(2);
		
		
		ItemPedido item3 = new ItemPedido();
		
		item3.setProduto(produto2);
		item3.setQuantidade(10);
		
		
		
		Pedido p1 = new Pedido();
		p1.adicionaItem(item1);
		p1.adicionaItem(item2);
		System.out.println(p1.getValorTotal()); 
		System.out.println("------------------------");
		
		
		Pedido p2 = new Pedido();
		p2.adicionaItem(item2);
		System.out.println(p2.getValorTotal()); 
		
	}

}
