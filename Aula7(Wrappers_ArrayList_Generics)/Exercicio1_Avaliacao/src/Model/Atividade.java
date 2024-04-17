package Model;

import java.util.Arrays;

public class Atividade {
	private char[] assunto;
	private int numPaginas;
	
	public Atividade() {
		super();
	}

	public Atividade(char[] assunto, int numPaginas) {
		this.assunto = assunto;
		this.numPaginas = numPaginas;
	}

	public char[] getAssunto() {
		return assunto;
	}

	public void setAssunto(char[] assunto) {
		this.assunto = assunto;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Override
	public String toString() {
		return "Atividade [assunto=" + Arrays.toString(assunto) + ", numPaginas=" + numPaginas + "]";
	}
	
	
}
