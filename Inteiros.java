import java.util.Scanner;

public class Inteiros extends Operacoes{
	static int max; //variavel usada na soma que ditara o numero maximo de bits da resposta
	String verbo;// string do verbo que aparece no programa de acordo com a operacao(somar, dividir...)
	static boolean divisao=false;// verfica se a operacao e uma divisao
	static boolean negativo=false;// verifica se o numero eh negativo
	static int parada;// variavel que ajuda no print da divisao
	
	/*metodo generico da conta. Cada classe de operacoes ira implementar seu proprio metodo conta*/
	char[] conta(char[] binario1,char[] binario2){
		return binario1;
	}
	
	/*verifica qual das operacoes foi chamada pelo usuario*/
	private static Inteiros verificaOperacaoInt(String operacao) {
        Inteiros numero;
        if(operacao.equalsIgnoreCase("A")) {
        	numero=new IntAdicao();
        	IntAdicao.intAdicao=true;
        }
        else if(operacao.equalsIgnoreCase("S")) numero=new IntSubtracao();
        else if(operacao.equalsIgnoreCase ("M")) numero=new IntMultiplicacao();
        else numero=new IntDivisao();
        return numero;
    }
	
	
	 public static void script(Scanner entrada) {
		char[] binario1;
		char[] binario2;
		System.out.print("Escreva qual operacao quer realizar:\n"+
				"[A]: adicao\n"+
				"[S]: subtracao\n" +
				"[M]: multiplicacao\n" +
				"[D]: divisao\n");
		String operacao= entrada.next();
		 if(operacao.equalsIgnoreCase("A")||operacao.equalsIgnoreCase("S")){
			 System.out.println("Digite qual sera a posicao do bit de sinal");
			 Inteiros.max= entrada.nextInt();
		 }
		Inteiros numero=verificaOperacaoInt(operacao);
		System.out.println("Escreva o bit de sinal do primeiro numero");
		String bitSinal=entrada.next();
		System.out.println("Escreva o primeiro numero que quer "+ numero.verbo);
		String primeiro= entrada.next();
		binario1=primeiro.toCharArray();
		if(bitSinal.equals("1")) binario1=IntSubtracao.complementoDeDois(binario1);
		primeiro=new String(binario1);
		primeiro=bitSinal.concat(primeiro);
		binario1=primeiro.toCharArray();
		
		System.out.println("Escreva o bit de sinal do segundo numero");
		bitSinal=entrada.next();
		System.out.println("Escreva o segundo numero que quer "+ numero.verbo);
		String segundo= entrada.next();
		binario2=segundo.toCharArray();
		if(bitSinal.equals("1")) binario2=IntSubtracao.complementoDeDois(binario2);
		segundo=new String(binario2);
		segundo=bitSinal.concat(segundo);
		binario2=segundo.toCharArray();
		char[] resultado = numero.conta(binario1, binario2);
		String res=new String(resultado);
		imprimeResultado(res);
		
	}

}

