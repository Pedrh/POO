package view;

import javax.swing.JOptionPane;

import controller.ContratacaoIntegral;
import controller.ContratacaoParcial;
import controller.ContratacaoTemporario;

public class Principal {

	public static void main(String[] args) {
		int tipo = 0;
		do {
		tipo = Integer.parseInt(JOptionPane.showInputDialog("Qual o tipo de funcionário a ser contratado: \n1- tempo integral \n2- tempo parcial \n3-temporario \n9- fim"));
		switch(tipo) {
		case 1:
			ContratacaoIntegral contratacaoI = new ContratacaoIntegral();
			System.out.println(contratacaoI.iniciarContratacao());
			break;
		case 2:
			ContratacaoParcial contratacaoP = new ContratacaoParcial();
			System.out.println(contratacaoP.iniciarContratacao());
			break;
		case 3:
			ContratacaoTemporario contratacaoT = new ContratacaoTemporario();
			System.out.println(contratacaoT.iniciarContratacao());
			break;
		case 9:
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		}while(tipo!= 9);
	}

}
