import java.util.Scanner;


public class Operacoes {
	
	static int max;
	String verbo;
	static boolean divisao=false;
	static boolean negativo=false;
	static int parada;
	
	static char[] combinar(char[]c1,char[]c2) {
		char[] combinado=new char[c1.length+c2.length];
		int i;
		combinado[0]=c2[0];
		for(i=0;i<c1.length;i++) combinado[i+1]=c1[i];
		int j=1;
		for(i=c1.length+1;i<combinado.length;i++) {
			combinado[i]=c2[j];
			j++;
		}
		return combinado;
	}
	
	static char adicaoSimples(char b1,char b2,char ci) {
		return (b1 == '0' && b2 == '0' && ci == '0') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '0' : '1';

	}
	
	static char carryOut(char b1,char b2,char ci) {
		return (b1 == '1' && b2 == '1' && ci == '1') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '1' : '0';
	}
	
	char[] conta(char[] binario1,char[] binario2){
		return binario1;
	}
	
	private static void imprimeResultado(char[] res) {
		System.out.print("Seu resultado(com bit de sinal) foi: ");
		if(divisao&&res[0]!='0'){
		    for(int i=parada;i<res.length;i++){
		        System.out.print(res[i]);
            }
        }
        else System.out.print(res);
        System.out.println();
        System.out.print("Resto: ");
        System.out.print(Divisao.resto);
	}
	
	private static Operacoes verificaOperacao(String operacao) {
        Operacoes numero;
        if(operacao.equalsIgnoreCase("A")) numero=new Adicao();
        else if(operacao.equalsIgnoreCase("S")) numero=new Subtracao();
        else if(operacao.equalsIgnoreCase ("M")) numero=new Multiplicacao();
        else numero=new Divisao();
        return numero;
    }
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite qual bit será o bit de sinal");
		max= entrada.nextInt();
		System.out.print("Escreva qual operacao quer realizar:\n"+
				"[A]: adicao\n"+
				"[S]: subtracao\n" +
				"[M]: multiplicacao\n" +
				"[D]: divisao\n");
		String operacao= entrada.next();
		Operacoes numero=verificaOperacao(operacao);
		System.out.println("Escreva os dois numeros binarios que quer "+ numero.verbo + ", com o bit de sinal:");
		System.out.println("[1]: numero negativo");
		System.out.println("[0]: numero positivo");
		String primeiro= entrada.next();
		String segundo= entrada.next();
		char[] binario1=primeiro.toCharArray();
		char[] binario2=segundo.toCharArray();
		char[] resultado = numero.conta(binario1, binario2);
		imprimeResultado(resultado);

	}

}
