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
		IntSubtracao sub=new IntSubtracao();
		int i=0;
		char[] antes1;
		char[] antes2;
		char[] depois1;
		char[] depois2;
		char[] antes;
		char[] depois;
		String bitSinalFinal="-1";
		String auxExpo1=expoente1;
		String auxExpo2=expoente2;
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
		while(binario1.charAt(0)!='1'&& binario1.charAt(1)!=',')binario1=binario1.substring(1);
		while(binario2.charAt(0)!='1'&&binario2.charAt(1)!=',') binario2=binario2.substring(1);
		System.out.println("Binario1: "+binario1);
		System.out.println("Binario2: "+binario2);
		
		/*cria dois arrays de string que contem as partes antes e depois da virgula*/
		String[] partesBinario1=new String[2];
		partesBinario1=binario1.split(",");
		String[] partesBinario2=new String[2];
		partesBinario2=binario2.split(",");
		antes1=partesBinario1[0].toCharArray();
		antes2=partesBinario2[0].toCharArray();
		/*verifica qual das duas sequencias antes da virgula é maior e atualiza o max da adicao de inteiros 
		 * e o bit de sinal do resultado(se os expoentes forem iguais) de acordo com qual é maior*/
		if(antes1.length>antes2.length) {
			if(maior.equals("0"))bitSinalFinal=bitSinal1;
			Inteiros.max=antes1.length;
		}
		else if(antes1.length<antes2.length) {
			if(maior.equals("0"))bitSinalFinal=bitSinal2;
			Inteiros.max=antes2.length;
		}
		else Inteiros.max=antes1.length+1;
		/*se o bit de sinal do resultado ainda nao foi definido, define 
		 * de acordo com qual das duas sequencias anteriores a virgula é maior*/
		
		if(bitSinalFinal.equals("-1")) {
			while(antes1[i]==antes2[i]) {
				i++;
				if(i==antes1.length) break;
			}
			if(i==antes1.length) {
			}else if(antes1[i]=='1') bitSinalFinal=bitSinal1;
			else bitSinalFinal=bitSinal2;
		}
		antes=add.conta(antes1, antes2);//faz a conta para descobrir qual e a sequencia antes da virgula no resultado
		
		/*pega os dois numeros apos a virgula,ve qual e maior e atualiza 
		 * a variavel max de acordo com a conclusao*/
		depois1=partesBinario1[1].toCharArray();
		depois2=partesBinario2[1].toCharArray();
		if(depois1.length>depois2.length) Inteiros.max=depois1.length;
		else if(depois1.length<depois2.length)Inteiros.max=depois2.length;
		else Inteiros.max=depois2.length+1;
		
		/*se o bit de sinal do resultado ainda nao foi definido, verifica qual dos dois numeros apos a virgula
		 *  e menor, e atualiza o bit de sinal de acordo com a conclusao*/
		if(bitSinalFinal.equals("-1")) {
			String temp1=new String(depois1);
			String temp2=new String(depois2);
			char[] auxTemp1=temp1.toCharArray();
			char[] auxTemp2=temp2.toCharArray();
			char[] auxMaior=sub.conta(auxTemp1, auxTemp2);
			if(auxMaior[0]=='1') bitSinalFinal=bitSinal2;
			else bitSinalFinal=bitSinal1;
		}
		depois=add.conta(depois1, depois2);//faz a conta dos dois numeros apos a virgula, para descobrir o resultado
		System.out.println(antes);
		System.out.println(depois);
		char[] binario3=combinar(antes,depois);//cria o array que representa o binario resultante sem a virgula
		i=0;
		while(binario3[i]!='1') i++;// verifica em qual posicao sera posta a virgula
		String resultado=new String(binario3);
		Inteiros.max=tamanhoExpoente;
		int vezes=antes.length-(i+1);//calcula a diferenca entre o expoente atual e o normalizado
		char[] aux=expoente1.toCharArray();
		
		/*normaliza o expoente*/
		if(vezes>0) {
			while(vezes>0) {
				char[] um= {'0','1'};
				aux=add.conta(aux, um);
				vezes--;
			}
		}else if(vezes<0) {
			while(vezes<0) {
				Floats.floatAdicao=false;
				char[] um= {'1','1'};
				aux=add.conta(aux, um);
				vezes++;
			}
		}
		resultado=resultado.substring(0, i+1)+","+resultado.substring(i+1, resultado.length());//coloca a virgula
		System.out.println("Normalizado: "+resultado);
		System.out.print("Expoente: ");
		System.out.print(aux);
		String[] partesResultado=new String[2];
		partesResultado=resultado.split(",");//"retira" o 1, que nao aparece na mantissa
		
		/*verifica se a mantissa tem 23 bits, e se nao tiver, adiciona ou retira zeros*/
		while(partesResultado[1].length()<23)
			partesResultado[1]=partesResultado[1]+"0";
		
		while(partesResultado[1].length()!=23) {
			partesResultado[1]=partesResultado[1].substring(0,partesResultado[1].length()-1);
		}
		System.out.println("Mantissa: "+partesResultado[1]);
		String resultadoFinal=bitSinalFinal.concat(new String(aux));
		resultadoFinal=resultadoFinal.concat(partesResultado[1]);
		System.out.println("Resultado: "+resultadoFinal);
		return resultadoFinal;
	}

}
