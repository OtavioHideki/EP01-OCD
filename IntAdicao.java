import java.util.Arrays;

public class IntAdicao extends Inteiros{

	/*construtor que troca o verbo por somar*/
	IntAdicao() {
		this.verbo="somar";
	}

	/*método que faz a adição de dois binários*/
	char[] conta(char[] binario1,char[] binario2){
		char[] resultado=new char[max];//cria o array do resultado, com tamanho "max"
		int i=max-1;

		
		if(binario2.length<max) { //verifica se o binário 2 é menor que o max, e se for, completa o binário até o tamanho ser igual a max
			char[] temp=binario2;
			char[] add=new char[max-binario2.length];
			if(binario2[0]=='0'||Floats.floatAdicao) Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario2=combinar(add,temp);
		}

		/*mesma coisa do outro if, só que com o binário 1*/
		if(binario1.length<max) {
			char[] temp=binario1;
			char[] add=new char[max-binario1.length];
			if(binario1[0]=='0'||Floats.floatAdicao) Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario1=combinar(add,temp);
		}

		/*for que faz a adição completa*/
		char carryIn='0';
		for(;i>=0;i--) {
			resultado[i]=adicaoSimples(binario1[i],binario2[i],carryIn);
			carryIn=carryOut(binario1[i],binario2[i],carryIn);
		}
		if(Floats.floatAdicao&&resultado[0]=='0') {
			String auxResultado=new String(resultado);
			auxResultado=auxResultado.substring(1);
			resultado=auxResultado.toCharArray();
		}
		/*verifica overflow*/
		if(binario1[0]==binario2[0]&&resultado[0]!=binario1[0]&& !divisao&&!Floats.floatAdicao) {
			System.out.println("Overflow");
			System.exit(0);
		}
		/*verifica se o resultado é negativo*/
		if(resultado[0]=='1') Inteiros.negativo=true;
		else negativo=false;
		return resultado;
	}
}
