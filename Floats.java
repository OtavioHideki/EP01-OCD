import java.util.Scanner;
public class Floats extends Operacoes {
	static int tamanhoExpoente=8;
	public static boolean operacaoFloat;
	public static boolean fim=false;
	static String bitSinal1;
	static String bitSinal2;
	static String bitSinalFinal="-1";
	static String binario1;
	static String binario2;
	static String expoente1;
	static String expoente2;
	static String maior="0";

	
	public String conta(String binario1,String binario2,String expoente1,String expoente2) {
		return binario1;
	}
	/*soma cento e vinte e oito ao expoente*/
	static String somarCentoEVinteOito(String expoente) {
		char[] centoVinteOito= {'0','1','0','0','0','0','0','0','0'};
		Inteiros add=new IntAdicao();
		Inteiros.max=tamanhoExpoente+1;
		char[] expoenteAux=expoente.toCharArray();
		expoenteAux=add.conta(expoenteAux,centoVinteOito);
		expoente=new String(expoenteAux);
		return expoente;
	}
	/*verifica qual das operacoes em float sera chamada*/
	private static Floats verificaOperacaoFloats(String operacao) {
		Floats numero;
        if(operacao.equalsIgnoreCase("A")) numero=new FloatAdicao();
        else if(operacao.equalsIgnoreCase("S")) numero=new FloatSubtracao();
        else if(operacao.equalsIgnoreCase ("M")) numero=new FloatMultiplicacao();
        else numero=new FloatDivisao();
        return numero;
	}
	/*script(o que aparece para o usuario)*/
	public static void script(Scanner entrada) {
		
		System.out.print("Escreva qual operacao quer realizar:\n"+
				"[A]: adicao\n"+
				"[S]: subtracao\n" +
				"[M]: multiplicacao\n" +
				"[D]: divisao\n");
		String operacao= entrada.next();
		Floats numero=verificaOperacaoFloats(operacao);
		System.out.println("Primeiro float");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Escreva o bit de sinal:");
		bitSinal1=entrada.next();
		System.out.println("Escreva o binario com virgula(sem expoente e sem bit de sinal):");
		binario1=entrada.next();
		if(bitSinal1.equals("1")) {
			char[] binarioAux=binario1.toCharArray();
			binarioAux=IntSubtracao.complementoDeDois(binarioAux);
			binario1=new String(binarioAux);
			
		}
		System.out.println("Escreva o bit de sinal do expoente:");
		String sExpo=entrada.next();
		System.out.println("Escreva o expoente:");
		String expo=entrada.next();
		if(sExpo.equals("1")) {
			char[] auxExpoente=expo.toCharArray();
			auxExpoente=IntSubtracao.complementoDeDois(auxExpoente);
			expo=new String(auxExpoente);
		}
		expoente1=sExpo.concat(expo);
		if(expoente1.length()>tamanhoExpoente&&sExpo.equals("0")) {
			System.out.println("Overflow de Expoente");
			System.exit(0);
		}
		expoente1=somarCentoEVinteOito(expoente1);
		if(expoente1.charAt(0)=='1') {
			System.out.println("Underflow de Expoente");
			System.exit(0);
		}
		System.out.println("Segundo float");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Escreva o bit de sinal:");
		bitSinal2=entrada.next();
		System.out.println("Escreva o binario com virgula(sem expoente e sem bit de sinal):");
		binario2=entrada.next();
		if(bitSinal2.equals("1")) {
			char[] binarioAux=binario2.toCharArray();
			binarioAux=IntSubtracao.complementoDeDois(binarioAux);
			binario2=new String(binarioAux);
			
		}
		System.out.println("Escreva o bit de sinal do expoente:");
		sExpo=entrada.next();
		System.out.println("Escreva o expoente:");
		expo=entrada.next();
		if(sExpo.equals("1")) {
			char[] auxExpoente=expo.toCharArray();
			auxExpoente=IntSubtracao.complementoDeDois(auxExpoente);
			expo=new String(auxExpoente);
		}
		expoente2=sExpo.concat(expo);
		if(expoente2.length()>tamanhoExpoente&&sExpo.equals("0")) {
			System.out.println("Overflow de Expoente");
			System.exit(0);
		}
		expoente2=somarCentoEVinteOito(expoente2);
		if(expoente2.charAt(0)=='1') {
			System.out.println("Underflow de Expoente");
			System.exit(0);
		}
		String resultado=numero.conta(binario1,expoente1,binario2,expoente2);
		imprimeResultado(resultado);

	}
}
