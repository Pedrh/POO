package view;

import model.ContaEspecial;
import model.ContaPoupanca;

public class Contas {
	public static void main(String[] args) {
		ContaEspecial contEspecial = new ContaEspecial();
		ContaPoupanca contPoupanca = new ContaPoupanca();
		
		
		contEspecial.setCliente("Jessica");
		contEspecial.setLimite(1000);
		contEspecial.setNum_conta(125);
		contEspecial.setSaldo(2300.00f);
		
		contPoupanca.setCliente("Adolfo");
		contPoupanca.setDiaRendimento(6);
		contPoupanca.setNum_conta(456);
		contPoupanca.setSaldo(3000);
		
		contPoupanca.sacar(1000); //saque dentro do saldo
		contEspecial.sacar(500); //saque dentro do saldo
		
		contPoupanca.sacar(2500); //saque fora do saldo
		
		contEspecial.sacar(3000); // saque fora do saldo e fora do limite
		contEspecial.sacar(1900); //saque fora do saldo e dentro do limite
		
		contPoupanca.calcularNovoSaldo(); //calcular o novo saldo com o rendimento
		System.out.println("O novo saldo com redimento é: " + contPoupanca.getSaldo());
		
		System.out.println("----------------------------");
		System.out.println(contEspecial.getCliente() + "\rNº conta: " + contEspecial.getNum_conta() + " - Saldo: " + contEspecial.getSaldo() + "(limite de " + contEspecial.getLimite() + ")");
		
		
	}
}
