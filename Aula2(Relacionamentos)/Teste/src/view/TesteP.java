package view;

import model.ItemPedido;
import model.Pedido;
//import model.Produto;

public class TesteP {

	public static void main(String[] args) {
		ItemPedido item1 = new ItemPedido();
		
		item1.setNome("Carro");
		item1.setQuantidade(5);
		
		
		Pedido p1 = new Pedido();
		System.out.println(p1.getListaItem().isEmpty());
		p1.adicionaItem(item1);
		
		
	}

}