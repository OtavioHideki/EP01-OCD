import java.util.Arrays;

public class IntAdicao extends Inteiros{
	public static boolean intAdicao=false;

	/*construtor que troca o verbo por somar*/
	IntAdicao() {
		this.verbo="somar";
	}
	/* funcao que combina dois arrays de char */
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
	/*funcao que soma 3 bits: bit 1, bit 2 e o carryIn*/
	static char adicaoSimples(char b1,char b2,char ci) { //
		return (b1 == '0' && b2 == '0' && ci == '0') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '0' : '1';

	}

	/*funcao que determina o carryOut*/
	static char carryOut(char b1,char b2,char ci) {
		return (b1 == '1' && b2 == '1' && ci == '1') || (b1 == '0' && b2 == '1' && ci == '1') || (b1 == '1' && b2 == '0' && ci == '1') || (b1 == '1' && b2 == '1' && ci == '0') ? '1' : '0';
	}

	/*metodo que faz a adicao de dois binarios*/
	char[] conta(char[] binario1,char[] binario2){
		char[] resultado=new char[max];//cria o array do resultado, com tamanho "max"
		int i=max-1;

		
		if(binario2.length<max) { //verifica se o binario 2 eh menor que o max, e se for, completa o binario ate o tamanho ser igual a max
			char[] temp=binario2;
			char[] add=new char[max-binario2.length];
			if(binario2[0]=='0') Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario2=combinar(add,temp);
		}

		/*mesma coisa do outro if, so que com o binario 1*/
		if(binario1.length<max) {
			char[] temp=binario1;
			char[] add=new char[max-binario1.length];
			if(binario1[0]=='0') Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario1=combinar(add,temp);
		}

		/*for que faz a adicao completa*/
		char carryIn='0';
		for(;i>=0;i--) {
			resultado[i]=adicaoSimples(binario1[i],binario2[i],carryIn);
			carryIn=carryOut(binario1[i],binario2[i],carryIn);
		}
		/*verifica overflow*/
		if(binario1[0]==binario2[0]&&resultado[0]!=binario1[0]) {
			if(Floats.fim||IntMultiplicacao.mult) {
				if(carryIn=='1') {
					String auxResultado=new String(resultado);
					auxResultado="1"+auxResultado;
					resultado=auxResultado.toCharArray();
					Floats.bitSinalFinal="0";
					Floats.fim=false;
				
				}
			}else if(!Floats.operacaoFloat) {
				System.out.println("Overflow");
				System.exit(0);

			}
		}
		/*verifica se o resultado eh negativo*/
		if(resultado[0]=='1') Inteiros.negativo=true;
		else negativo=false;
		if(Floats.fim&&Floats.bitSinalFinal.equals("-1")) {
			char bs1=Floats.bitSinal1.charAt(0);
			char bs2=Floats.bitSinal2.charAt(0);
			char bsf=adicaoSimples(bs1,bs2,carryIn);
			char[] bitF= {bsf};
			Floats.bitSinalFinal=new String(bitF);
		}
		return resultado;
	
	}
}
