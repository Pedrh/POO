package view;

public class Teste {

	public static void main(String[] args) {
		System.out.println("Inicio do main");
		try {
			metodo1();
		
		} catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Tamanho do vetor inválido");
		}catch(ArithmeticException e2){
			System.out.println("Impossível divisão por 0");
		} 
			System.out.println("Fim do main");
	}

	public static void metodo1()throws ArrayIndexOutOfBoundsException, ArithmeticException {
		System.out.println("Inicio do método 1");
		metodo2();
		System.out.println("Fim do método 1");
	}

	public static void metodo2() throws ArrayIndexOutOfBoundsException, ArithmeticException{
		System.out.println("Início do método 2");
		
		int[] vetor = new int[10];
			for(int i = 0; i <= 15; i++) { // maior que o tamanho do vetor
				vetor[i] = i;
				System.out.println(i);
				if(i == 9) {
					int vlr = vetor[i] / vetor[0]; //o primeiro valor é 0 
					System.out.println(vlr);
				}
			}
		System.out.println("Fim do método 2");
	}

}
