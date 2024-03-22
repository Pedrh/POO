package model;

import fateczl.Lista.model.Lista;

public class Playlist {

	private Lista<Musica> musicas;
	private String dono;
	
	public Playlist() {
		super();
		musicas = new Lista<Musica>();
	}
	
	public String getDono() {
		return this.dono;
	}
	
	public void setDono(String dono) {
		this.dono = dono;
	}
	
	
	public Lista<Musica> getMusicas() {
		return this.musicas;
	}
	
	public void addMusica(Musica musicaNova) {
		try {
			musicas.addLast(musicaNova);
			System.out.println("A música " + musicaNova.getNome() + " foi adicionada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playMusica(Musica musicaTocar) {
		int tamanho = musicas.size();
		for(int i = 0; i < tamanho; i++) {
			try {
				Musica musicaCheck = musicas.get(i);
				if(musicaCheck.getNome() == musicaTocar.getNome()) {
					System.out.println("Tocando - " + musicaTocar.getNome() + "\r");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void aleatorio() {
		Lista<Musica> musicaPassada = new Lista<Musica>();
		
		while(!musicas.isEmpty()) {
			int tamanho = musicas.size();
			double j = Math.random()* (tamanho + 0.01);
			try {
				int numMusica = (int) j;
				if(numMusica >= tamanho) {
					numMusica = tamanho - 1;
				}
				Musica musicaTocando = musicas.get(numMusica);
				System.out.println("Tocando a musica - " + musicaTocando.getNome());
				System.out.println("--------------");
				
				musicaPassada.addLast(musicas.get(numMusica));
				musicas.remove(numMusica);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		while(!musicaPassada.isEmpty()) {
			try {
				musicas.addLast(musicaPassada.get(0));
				musicaPassada.remove(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
