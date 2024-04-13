package view;

import model.Carga;
import model.Motor;
import model.Passeio;

public class Principal {

	public static void main(String[] args) {
		Passeio passeio1 = new Passeio();
		Motor motor1 = new Motor();
		
		motor1.setPotencia(150);
		motor1.setQtdPist(20);
		
		
		passeio1.setCor("Azul");
		passeio1.setMarca("Chevrolet");
		passeio1.setModelo("Uno");
		passeio1.setMotor(motor1);
		passeio1.setPlaca("154das51");
		passeio1.setQtdPassageiros(4);
		passeio1.setQtdRodas(4);
		passeio1.setVelocMax(120);
		
		passeio1.calcVel(passeio1.getVelocMax());
		System.out.println(passeio1.toString());
		
		
		Passeio passeio2 = new Passeio();
		Motor motor2 = new Motor();
		
		motor2.setPotencia(300);
		motor2.setQtdPist(40);
		
		
		passeio2.setCor("Vermelho");
		passeio2.setMarca("WoltsVagen");
		passeio2.setModelo("Voyage");
		passeio2.setMotor(motor2);
		passeio2.setPlaca("465879asd");
		passeio2.setQtdPassageiros(5);
		passeio2.setQtdRodas(4);
		passeio2.setVelocMax(300);
		
		passeio2.calcVel(passeio2.getVelocMax());
		System.out.println(passeio2.toString());
		
		
		Carga carga1 = new Carga();
		Motor motor3 = new Motor();
		
		motor3.setPotencia(500);
		motor3.setQtdPist(60);
		
		
		carga1.setCargaMax(500);
		carga1.setCor("Roxo");
		carga1.setMarca("Hyundai");
		carga1.setModelo("Caminhão");
		carga1.setMotor(motor3);
		carga1.setPlaca("Dasf54789");
		carga1.setQtdRodas(8);
		carga1.setTara(5);
		carga1.setVelocMax(250);
		
		carga1.calcVel(carga1.getVelocMax());
		System.out.println(carga1.toString());
		
		
		Carga carga2 = new Carga();
		Motor motor4 = new Motor();
		
		motor4.setPotencia(400);
		motor4.setQtdPist(40);
		
		
		carga2.setCargaMax(300);
		carga2.setCor("Amarelo");
		carga2.setMarca("Mercedes");
		carga2.setModelo("Ônibus");
		carga2.setMotor(motor4);
		carga2.setPlaca("648579245");
		carga2.setQtdRodas(8);
		carga2.setTara(9);
		carga2.setVelocMax(200);
		
		carga2.calcVel(carga2.getVelocMax());
		System.out.println(carga2.toString());
		
	}

}
