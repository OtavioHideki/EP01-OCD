
public class Subtracao extends Operacoes {
	
	public Subtracao() {
		this.verbo="subtrair";
	}
	
	public char[] complementoDeDois(char[] subtraido) {
		boolean troca=false;
		for(int i=subtraido.length-1;i>=0;i--) {
			if(troca==false) {
				if(subtraido[i]=='1') troca=true;
			} else{
				if(subtraido[i]=='1') subtraido[i]='0';
				else subtraido[i]='1';
			}
			
		}
		return subtraido;
	}
	char[] conta(char[] binario1,char[] binario2){
		Adicao add=new Adicao();
		char[] complementado=complementoDeDois(binario2);
		return add.conta(binario1, complementado);
	}
}
