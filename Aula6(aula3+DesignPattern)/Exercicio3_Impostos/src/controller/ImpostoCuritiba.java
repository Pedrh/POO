package controller;

import javax.swing.JOptionPane;

public class ImpostoCuritiba implements IImpostoStrategy {

	@Override
	public void calcularImposto() {
		float areaTotal = Float.parseFloat(JOptionPane.showInputDialog("Digite o tamanho da área total: "));
		int idadeImovel = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do imóvel: "));
		float imposto = areaTotal * 5;
		
		if(idadeImovel > 50) {
			imposto += idadeImovel * 3;
		} else if(idadeImovel < 20) {
			imposto += idadeImovel * 2;
		} else {
			imposto += idadeImovel * 2.5f;
		}
		
		System.out.println("O imposto para São Paulo é: R$" + imposto);
	}

}
