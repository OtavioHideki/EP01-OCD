import java.util.Scanner;


public class Operacoes {

	/* função que combina dois arrays de char */
	static char[] combinar(char[]c1,char[]c2) {
		char[] combinado=new char[c1.length+c2.length];
		int i;
		for(i=0;i<c1.length;i++) combinado[i]=c1[i];
		int j=0;
		for(i=c1.length;i<combinado.length;i++) {
			combinado[i]=c2[j];
			j++;
		}
		return combinado;
	}

	/*função que soma 3 bits: bit 1, bit 2 e o carryIn*/
	static char adicaoSimples(char b1,char b2,char ci) { //
		return (b1 == '0' && b2 == '0' && ci == '0') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '0' : '1';

	}

	/*função que determina o carryOut*/
	static char carryOut(char b1,char b2,char ci) {
		return (b1 == '1' && b2 == '1' && ci == '1') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '1' : '0';
	}
	
	char[] conta(char[] binario1,char[] binario2){
		return binario1;
	}


	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite qual tipo de numero vai usar:\n"+
				"[I]: inteiros\n"+
				"[F]: floats");
		String tipo=entrada.nextLine();
		if(tipo.equalsIgnoreCase("I")) Inteiros.script(entrada);
		if(tipo.equalsIgnoreCase("F")) Floats.script(entrada);
		

	}

}
