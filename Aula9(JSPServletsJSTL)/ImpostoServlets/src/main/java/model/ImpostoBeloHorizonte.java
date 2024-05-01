package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpostoBeloHorizonte implements IImpostoStrategy {

	private float areaTotal;
	private int numQuartos;
	private float imposto;
	
	public ImpostoBeloHorizonte() {
		super();
	}
	
	@Override
	public void calcularImposto() {
		setImposto((areaTotal * 7) + (numQuartos * 4));
	}

	@Override
	public String toString() {
		return "BELO HORIZONTE - AreaTotal: "+ areaTotal+"m, Numero de quartos: "+ numQuartos +", imposto a ser pago é: " + getImposto();
	}
}
