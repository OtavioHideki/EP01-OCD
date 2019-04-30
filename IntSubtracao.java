
public class IntSubtracao extends Inteiros {

	/*construtor que troca o verbo por subtrair*/
	IntSubtracao() {
		this.verbo="subtrair";
	}

	/*método que aplica o complemento de dois sobre um binário*/
	 static char[] complementoDeDois(char[] subtracao) {
		boolean troca=false;
        for(int i = subtracao.length-1; i>=0; i--) {
			if(!troca) {
				if(subtracao[i]=='1') troca=true;
			} else{
				if(subtracao[i]=='1') subtracao[i]='0';
				else if(subtracao[i]=='0') subtracao[i]='1';
			}
			
		}
		return subtracao;
	}
	/*faz a subtração*/
	char[] conta(char[] binario1,char[] binario2){
		IntAdicao add=new IntAdicao();
		char[] complementado=complementoDeDois(binario2); //aplica complemento de dois em cima do subtraendo
		return add.conta(binario1, complementado);
	}
}
