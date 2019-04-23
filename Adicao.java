import java.util.Arrays;

public class Adicao extends Operacoes{
	
	Adicao() {
		this.verbo="somar";
	}
	
	char[] conta(char[] binario1,char[] binario2){
		char[] resultado=new char[max];
		int i=max-1;
		if(binario2.length<max) {
			char[] temp=binario2;
			char[] add=new char[max-binario2.length];
			if(binario2[0]=='0') Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario2=combinar(add,temp);
		}
		if(binario1.length<max) {
			char[] temp=binario1;
			char[] add=new char[max-binario1.length];
			if(binario1[0]=='0') Arrays.fill(add,'0');
			else Arrays.fill(add,'1');
			binario1=combinar(add,temp);
		}
		char carryIn='0';
		for(;i>=0;i--) {
			resultado[i]=adicaoSimples(binario1[i],binario2[i],carryIn);
			carryIn=carryOut(binario1[i],binario2[i],carryIn);
		}
		if(binario1[0]==binario2[0]&&resultado[0]!=binario1[0]&&divisao==false) {
			System.out.println("Overflow");
			System.exit(0);
		}
		if(resultado[0]=='1') Operacoes.negativo=true;
		else negativo=false;
		return resultado;
	}
}
