package view;

import model.Animal;
import model.Mamifero;
import model.Peixe;

public class TesteAnimais {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		
		animal1.setNome("Camelo");
		animal1.setComprimento(150);
		animal1.setPatas(4);
		animal1.setCor("Amarelo");
		animal1.setAmbiente("Terra");
		animal1.setVelocidade(2.0f);
		
		Peixe animal2 = new Peixe();
		
		animal2.setNome("Tubarao");
		animal2.setComprimento(300);
		animal2.setPatas(0);
		animal2.setCor("Cinzento");
		animal2.setAmbiente("Mar");
		animal2.setVelocidade(1.5f);
		animal2.setCaracteristica("Barbatanas e cauda");
		
		Mamifero animal3 = new Mamifero();
		
		animal3.setNome("Urso-do-canada");
		animal3.setComprimento(180);
		animal3.setPatas(4);
		animal3.setCor("Vermelho");
		animal3.setAmbiente("Terra");
		animal3.setVelocidade(0.5f);
		animal3.setAlimento("Mel");
		
		
		animal1.dados();
		
		System.out.println("--------------------------\n");
		animal2.dados();
		
		System.out.println("--------------------------\n");
		animal3.dados();
	}

}
