package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpostoCuritiba implements IImpostoStrategy {

	private float areaTotal;
	private int idadeImovel;
	private float imposto;
	
	public ImpostoCuritiba() {
		super();
	}
	
	@Override
	public void calcularImposto() {
		setImposto(areaTotal * 5);
		
		if(getIdadeImovel() > 50) {
			setImposto(getImposto() + getIdadeImovel() * 3);
		} else if(getIdadeImovel() < 20) {
			setImposto(getImposto() + getIdadeImovel() * 2);
		} else {
			setImposto(getImposto() + getIdadeImovel() * 2.5f);
		}
	}

	@Override
	public String toString() {
		return "CURITIBA - AreaTotal: "+ areaTotal+"m, Idade do imovel: "+ idadeImovel +", imposto a ser pago é: " + getImposto();
	}
}
