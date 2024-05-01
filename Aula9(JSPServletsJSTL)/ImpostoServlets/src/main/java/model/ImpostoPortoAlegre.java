package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpostoPortoAlegre implements IImpostoStrategy{
	
	private float areaTotal;
	private String garagem;
	private float areaGaragem;
	private float imposto;
	
	public ImpostoPortoAlegre() {
		super();
	}
	
	@Override
	public void calcularImposto() {
		if(garagem.equalsIgnoreCase("on")) {
			setImposto(getAreaTotal() * 8);
		}else {
			setImposto((getAreaTotal() * 7.5f) + (getAreaGaragem() * 2.5f)) ;
		}
	}

	@Override
	public String toString() {
		String temGaragem = "";
		if(garagem.equalsIgnoreCase("on")) {
			temGaragem = "Sim";
			return "PORTO ALEGRE - AreaTotal: "+ areaTotal+"m, Garagem: "+ temGaragem + ", Area da garagem: "+ areaGaragem +", imposto a ser pago é: " + getImposto();
		}else {
			temGaragem = "Não";
			return "PORTO ALEGRE - AreaTotal: "+ areaTotal+"m, Garagem: "+ temGaragem +", imposto a ser pago é: " + getImposto();
		}
	}
}
