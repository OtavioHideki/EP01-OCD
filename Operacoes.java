import java.util.Scanner;


public class Operacoes {

	/*imprime o resultado*/
	public static void imprimeResultado(String res) {
		System.out.print("Seu resultado(com bit de sinal) foi: ");
		while(res.charAt(0)==res.charAt(1)) {
			res=res.substring(1);
			if(res.length()==1) break;
		}
		System.out.println(res);
		if(res.charAt(0)=='1'&&!Floats.operacaoFloat) {
			System.out.print("Ou sem complemento de 2: -");
			char[] resultado=res.toCharArray();
			resultado=IntSubtracao.complementoDeDois(resultado);
			System.out.println(resultado);
		}
		if(Inteiros.divisao) {
			System.out.print("Resto: ");
			System.out.print(IntDivisao.resto);
        }
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite qual tipo de numero vai usar:\n"+
				"[I]: inteiros\n"+
				"[F]: floats");
		String tipo=entrada.nextLine();
		if(tipo.equalsIgnoreCase("I")) Inteiros.script(entrada);
		if(tipo.equalsIgnoreCase("F")) {
			Floats.operacaoFloat=true;
			Floats.script(entrada);
		}
		

	}

}
