package controller;

import javax.swing.JOptionPane;

public class ImpostoBeloHorizonte implements IImpostoStrategy {

	@Override
	public void calcularImposto() {
		float areaTotal = Float.parseFloat(JOptionPane.showInputDialog("Digite o tamanho da área total: "));
		int numComodos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de comodos: "));
		float imposto = (areaTotal * 7) + (numComodos * 4);
		System.out.println("O imposto para Belo Horizonte é: R$" + imposto);
	}

}
