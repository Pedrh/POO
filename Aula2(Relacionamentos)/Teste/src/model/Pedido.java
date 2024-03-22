package model;

import fateczl.Lista.model.Lista;

public class Pedido {
	
	private int numeroNota;
	Lista<ItemPedido> listaItem;
	
	public Pedido() {
		super();
		listaItem = new Lista<ItemPedido>();
	}
	
	public int getNumeroNota(){
		return this.numeroNota;
	}
	
	public void setNumeroNota(int numeroNota) {
		this.numeroNota = numeroNota;
	}
	
	public Lista<ItemPedido> getListaItem(){
		return this.listaItem;
	}
	
	public void adicionaItem(ItemPedido item) {
		try {
			System.out.println(listaItem.isEmpty());
			
			listaItem.addLast(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

