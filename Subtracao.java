
public class Subtracao extends Operacoes {
	
	Subtracao() {
		this.verbo="subtrair";
	}
	
	 static char[] complementoDeDois(char[] subtracao) {
		boolean troca=false;
        for(int i = subtracao.length-1; i>=0; i--) {
			if(!troca) {
				if(subtracao[i]=='1') troca=true;
			} else{
				if(subtracao[i]=='1') subtracao[i]='0';
				else subtracao[i]='1';
			}
			
		}
		return subtracao;
	}
	char[] conta(char[] binario1,char[] binario2){
		Adicao add=new Adicao();
		char[] complementado=complementoDeDois(binario2);
		return add.conta(binario1, complementado);
	}
}
