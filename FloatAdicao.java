import java.util.Arrays;
public class FloatAdicao extends Floats {
	static int contador=0;
	
	public FloatAdicao() {
		Floats.floatAdicao=true;
	}
	
    public static String rightShift(String binario){
		int i=0;
		while(binario.charAt(i)!=',') i++;
		int posicaoVirgula=i;
		binario=binario.replace(",", "");
		binario=binario.substring(0, posicaoVirgula-contador)+","+binario.substring(posicaoVirgula-contador, binario.length());
		return binario;
    }	
    static String igualarExpoente(String expoente1, String expoente2) {
		String menor;
		int i=0;
		char[] um= {'0','0','1'};
		IntAdicao add=new IntAdicao();
		while(expoente1.charAt(i)==expoente2.charAt(i)) {
			i++;
			if(i==8) break;
		}
		if(i==8) return expoente1;
		if(expoente1.charAt(i)=='1') {
			maior=expoente1;
			menor=expoente2;
			
		}
		else{
			maior=expoente2;
			menor=expoente1;
		}
		char[] auxMenor=menor.toCharArray();
		char[] auxMaior=maior.toCharArray();
		while(!Arrays.equals(auxMenor, auxMaior)) {
			auxMenor=add.conta(auxMenor, um);
			contador++;
		}
		menor=new String(auxMenor);
		return menor;
	}
	public String conta(String binario1,String expoente1,String binario2,String expoente2) {
		IntAdicao add=new IntAdicao();
		int i=0;
		int tamanhoB1=binario1.length();
		int tamanhoB2=binario2.length();
		String auxExpo1=expoente1;
		String auxExpo2=expoente2;
		char[] auxBinario1;
		char[] auxBinario2;
		expoente1=FloatAdicao.igualarExpoente(expoente1,expoente2);//iguala os dois expoentes
		expoente2=FloatAdicao.igualarExpoente(expoente1,expoente2);//iguala os dois expoentes
		System.out.println("Expoente1: "+expoente1);
		System.out.println("Expoente2: "+expoente2);
		char[] zeros=new char[contador+1];// cria um array de zeros para a normalizacao ser possivel
		for(i=0;i<zeros.length;i++) {
			zeros[i]='0';
		}
		String zero=new String(zeros);
		binario1=zero.concat(binario1);//adiciona os zeros na frente do binario1
		binario2=zero.concat(binario2);//adiciona os zeros na frente do binario2
		
		/*verifica qual dos dois expoentes é maior e faz o right shift no menor*/
		if(maior.equals(auxExpo1)) {
			binario2=rightShift(binario2);
			bitSinalFinal=bitSinal1;
		
		}
		else if(maior.equals(auxExpo2)){
			bitSinalFinal=bitSinal2;
			binario1=rightShift(binario1);
		}
		/*retira os zeros ate o primeiro 1 ou ate a virgula*/
		while(binario1.charAt(0)!='1'&& binario1.charAt(1)!=','&&tamanhoB1<binario1.length())binario1=binario1.substring(1);
		while(binario2.charAt(0)!='1'&&binario2.charAt(1)!=','&&tamanhoB2<binario2.length()) binario2=binario2.substring(1);
		System.out.println("Binario1: "+binario1);
		System.out.println("Binario2: "+binario2);
		
		/*cria dois arrays de string que contem as partes antes e depois da virgula*/
		String[] partesBinario1=new String[2];
		partesBinario1=binario1.split(",");
		String[] partesBinario2=new String[2];
		partesBinario2=binario2.split(",");
		while(partesBinario1[1].length()<partesBinario2[1].length()) partesBinario1[1]=partesBinario1[1].concat("0");
		while(partesBinario2[1].length()<partesBinario1[1].length()) partesBinario2[1]=partesBinario2[1].concat("0");
		int x=partesBinario1[1].length();
		binario1=partesBinario1[0].concat(partesBinario1[1]);
		binario1=bitSinal1.concat(binario1);
		binario2=partesBinario2[0].concat(partesBinario2[1]);
		binario2=bitSinal2.concat(binario2);
		auxBinario1=binario1.toCharArray();
		auxBinario2=binario2.toCharArray();
		if(auxBinario1.length>=auxBinario2.length) Inteiros.max=auxBinario1.length;
		else Inteiros.max=auxBinario2.length;
		Floats.fim=true;
		char[] binario3=add.conta(auxBinario1, auxBinario2);
		Floats.fim=false;
		String resultado=new String(binario3);
		int posicaoVAnt=resultado.length()-x;
		i=0;
		while(resultado.charAt(i)=='0') {
			i++;
			if(i==resultado.length()) {
				System.out.println("0");
				String s="0";
				return s;
			}
		}
		resultado=resultado.substring(i,i+1)+","+resultado.substring(i+1, resultado.length());
		Inteiros.max=tamanhoExpoente+1;
		int vezes=posicaoVAnt-(i+1);//calcula a diferenca entre o expoente atual e o normalizado
		char[] aux=expoente1.toCharArray();
		
		/*normaliza o expoente*/
		if(vezes>0) {
			while(vezes>0) {
				char[] um= {'0','1'};
				aux=add.conta(aux, um);
				if(aux[0]=='1') {
					System.out.println("Overflow de Expoente");
					System.exit(0);
				}
				vezes--;
			}
		}else if(vezes<0) {
			char[] compara= {'1','1','1','1','1','1','1','1','1'};
			while(vezes<0) {
				char[] um= {'1','1'};
				aux=add.conta(aux, um);
				if(Arrays.equals(aux,compara)) {
					System.out.println("Underflow de Expoente");
					System.exit(0);
				}
				vezes++;
			}
		}
		System.out.println("Normalizado: "+resultado);
		System.out.print("Expoente: ");
		System.out.print(aux);
		String[] partesResultado=new String[2];
		partesResultado=resultado.split(",");//"retira" o 1, que nao aparece na mantissa
		String expoenteFinal=new String(aux);
		expoenteFinal=expoenteFinal.substring(1);
		/*verifica se a mantissa tem 23 bits, e se nao tiver, adiciona ou retira zeros*/
		while(partesResultado[1].length()<23)
			partesResultado[1]=partesResultado[1]+"0";
		
		while(partesResultado[1].length()!=23) {
			partesResultado[1]=partesResultado[1].substring(0,partesResultado[1].length()-1);
		}
		System.out.println("Mantissa: "+partesResultado[1]);
		String resultadoFinal=bitSinalFinal.concat(expoenteFinal);
		resultadoFinal=resultadoFinal.concat(partesResultado[1]);
		System.out.println("Resultado: "+resultadoFinal);
		return resultadoFinal;
	}

}
