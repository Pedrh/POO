package view;

import model.Musica;
import model.Playlist;

public class Principal {

	public static void main(String[] args) {
		Playlist playlist = new Playlist();
		
		Musica musica1 = new Musica();
		
		musica1.setNome("Singing in the rain");
		musica1.setAutor("Frank Sinatra");
		musica1.setGravadora("Pipoquinhas");
		
		Musica musica2 = new Musica();
		
		musica2.setNome("Diamonds");
		musica2.setAutor("Rihana");
		musica2.setGravadora("New records");
		
		Musica musica3 = new Musica();
		
		musica3.setNome("Someone like you");
		musica3.setAutor("Adelle");
		musica3.setGravadora("Lucas producoes");
		
		Musica musica4 = new Musica();
		
		musica4.setNome("Carinhoso");
		musica4.setAutor("Caetano veloso");
		musica4.setGravadora("Industria da musica");
		
		playlist.addMusica(musica1);
		playlist.addMusica(musica2);
		playlist.addMusica(musica3);
		playlist.addMusica(musica4);
		
		playlist.playMusica(musica2);
		
		playlist.aleatorio();
	}

}
