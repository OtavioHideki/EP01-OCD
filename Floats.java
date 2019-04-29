import java.util.Scanner;
public class Floats extends Operacoes {
	static int tamanhoMantissa=23;
	static int tamanhoExpoente=8;
	public static boolean floatAdicao;
	static String bitSinal1;
	static String bitSinal2;
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
		char[] centoVinteOito= {'1','0','0','0','0','0','0','0'};
		Inteiros add=new IntAdicao();
		Inteiros.max=tamanhoExpoente;
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
		System.out.println("Escreva o bit de sinal do primeiro float");
		bitSinal1=entrada.next();
		System.out.println("Escreva o primeiro float com virgula(sem expoente e sem bit de sinal");
		binario1=entrada.next();
		System.out.println("Escreva o expoente do primeiro float");
		expoente1=entrada.next();
		expoente1=somarCentoEVinteOito(expoente1);
		System.out.println("Escreva o bit de sinal do segundo float");
		bitSinal2=entrada.next();
		System.out.println("Escreva o segundo float com virgula(sem expoente e sem bit de sinal");
		binario2=entrada.next();
		System.out.println("Escreva o expoente do segundo float");
		expoente2=entrada.next();
		expoente2=somarCentoEVinteOito(expoente2);
		System.out.println(expoente1);
		System.out.println(expoente2);
		String s=numero.conta(binario1,expoente1,binario2,expoente2);

	}
}
