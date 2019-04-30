import java.util.Scanner;

public class Inteiros extends Operacoes{
	static int max; //variavel usada na soma que ditará o numero maximo de bits da resposta
	String verbo;// string do verbo que aparece no programa de acordo com a operacao(somar, dividir...)
	static boolean divisao=false;// verfica se a operacao e uma divisao
	static boolean negativo=false;// verifica se o numero é negativo
	static int parada;// variavel que ajuda no print da divisao
	
	/*método genérico da conta. Cada classe de operações irá implementar seu próprio metodo conta*/
	char[] conta(char[] binario1,char[] binario2){
		return binario1;
	}
	
	/*verifica qual das operçãoes foi chamada pelo usuário*/
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
		System.out.println("Digite qual bit sera o bit de sinal");
		Inteiros.max= entrada.nextInt();
		System.out.print("Escreva qual operacao quer realizar:\n"+
				"[A]: adicao\n"+
				"[S]: subtracao\n" +
				"[M]: multiplicacao\n" +
				"[D]: divisao\n");
		String operacao= entrada.next();
		Inteiros numero=verificaOperacaoInt(operacao);
		System.out.println("Escreva os dois numeros binarios que quer "+ numero.verbo + ", com o bit de sinal:");
		System.out.println("[1]: numero negativo");
		System.out.println("[0]: numero positivo");
		String primeiro= entrada.next();
		String segundo= entrada.next();
		char[] binario1=primeiro.toCharArray();
		char[] binario2=segundo.toCharArray();
		char[] resultado = numero.conta(binario1, binario2);
		Inteiros.imprimeResultadoInteiro(resultado);
		
	}
	
	/*imprime o resultado*/
	public static void imprimeResultadoInteiro(char[] res) {
		System.out.print("Seu resultado(com bit de sinal) foi: ");
		if(divisao) {
			if(res[0]!='0'){
				for(int i=parada;i<res.length;i++){
					System.out.print(res[i]);
				}
			}else System.out.print(res);
			System.out.println();
			System.out.print("Resto: ");
			System.out.print(IntDivisao.resto);
        }
        else System.out.print(res);
        
	}

}

