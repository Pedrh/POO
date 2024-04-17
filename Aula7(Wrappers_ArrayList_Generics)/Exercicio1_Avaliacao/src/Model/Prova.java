package Model;

public class Prova {
	private int questao;
	private float media;
	
	public Prova() {
		super();
	}

	public Prova(int questao, float media) {
		this.questao = questao;
		this.media = media;
	}

	public int getQuestao() {
		return questao;
	}

	public void setQuestao(int questao) {
		this.questao = questao;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Prova [questao=" + questao + ", media=" + media + "]";
	}
	
	
	
}
