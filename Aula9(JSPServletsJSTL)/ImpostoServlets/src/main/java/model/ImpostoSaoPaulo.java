package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpostoSaoPaulo implements IImpostoStrategy {

	private float areaTotal;
	private int numComodos;
	private float imposto;
	
	public ImpostoSaoPaulo() {
		super();
	}
	
	@Override
	public void calcularImposto() {
		setImposto((areaTotal * 10) + (numComodos * 2));
	}

	@Override
	public String toString() {
		return "SAO PAULO - AreaTotal: "+ areaTotal+"m, Numero de comodos: "+ numComodos +", imposto a ser pago é: " + getImposto();
	}
}
