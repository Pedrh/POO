package controller;

import javax.swing.JOptionPane;

public class ImpostoPortoAlegre implements IImpostoStrategy{
	
	@Override
	public void calcularImposto() {
		float areaTotal = Float.parseFloat(JOptionPane.showInputDialog("Digite o tamanho da área total: "));
		String garagem = JOptionPane.showInputDialog("Tem garagem? S ou N");
		float imposto = 0;
		if(garagem.equalsIgnoreCase("N")) {
			imposto = areaTotal * 8;
		}else {
			float areaGaragem = Float.parseFloat(JOptionPane.showInputDialog("Digite o tamanho da garagem: "));
			imposto = (areaTotal * 7.5f) + (areaGaragem * 2.5f);
		}
		System.out.println("O imposto para Porto alegre é: R$" + imposto);
	}

}
