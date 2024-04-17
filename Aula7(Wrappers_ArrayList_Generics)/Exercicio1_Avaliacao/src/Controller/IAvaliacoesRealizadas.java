package Controller;

public interface IAvaliacoesRealizadas<E> {
	
	public void adicionarAvaliacao(E e);
	public void removerAvaliacao(E e);
	public E encontrarAvaliacao(int posicao);
	public void limparAvaliacoes();
	public void mostrarAvaliacoes();
}
