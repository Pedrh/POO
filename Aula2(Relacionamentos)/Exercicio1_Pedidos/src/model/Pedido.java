package model;

import fateczl.Lista.model.Lista;

public class Pedido {
	
	private int numeroNota;
	private double valorTotal;
	private Lista<ItemPedido> listaItem;
	
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
	
	public double getValorTotal() {
		int tamanho = listaItem.size();
		for(int i = 0; i < tamanho; i++) {
			try {
				this.valorTotal  += (listaItem.get(i).getQuantidade() * listaItem.get(i).getProduto().getValor());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.valorTotal;
	}
	
	public void adicionaItem(ItemPedido item) {
		try {
			if(listaItem.isEmpty()) {
				listaItem.addFirst(item);
			}else {
				listaItem.addLast(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
