
public class IntDivisao extends Inteiros {
    static char[] resto;

    /*construtor que troca o verbo por dividir e confirma que esta sendo feita uma divisao*/
    IntDivisao(){
        this.verbo="dividir";
        Inteiros.divisao=true;
    }
    /*faz a divisao*/
    char[] conta(char[] binario1, char[] binario2){
    	if(binario1.length<=binario2.length) Inteiros.max=binario2.length;
    	else Inteiros.max=binario1.length;
        char bitSinal1=binario1[0];

        /*aplica complemento de dois em cima do binario que for negativo*/
        if(bitSinal1=='1') {
           binario1=IntSubtracao.complementoDeDois(binario1);
        }
        char bitSinal2=binario2[0];
        if(bitSinal2=='1') {
            binario2=IntSubtracao.complementoDeDois(binario2);
        }
        String aux1=new String(binario2);
        char[] aux2=aux1.toCharArray();
        IntSubtracao sub=new IntSubtracao();
        IntAdicao add=new IntAdicao();
        resto=sub.conta(binario1,aux2);
        int contador=1; //contador que verificara quantas subtracoes foram feitas

        /*subtrai divisor do dividendo ate o resto ser negativo*/
        while(!negativo){
            contador++;
            aux2=aux1.toCharArray();
            char[] binario3=resto;
            resto=sub.conta(binario3,aux2);
        }
        aux2=aux1.toCharArray();
        resto=add.conta(resto,aux2); //soma o divisor ao dividendo para achar o resto
        contador--; //diminui o contador em 1 pois foi feita uma subtracao a mais
        int i=max-1;
        char[] binarioContador=new char[max];
        if(contador==0) {
        	char[] resultado= {'0','0'};
        	return resultado;
        }
        /*transforma o contador em binario*/
        while(contador/2!=0&&i>0){
            binarioContador[i]=Character.forDigit(contador%2,10);
            contador=contador/2;
            i--;

        }
        binarioContador[i]=Character.forDigit(contador,10);
        parada=i-1; //atualiza a variavel parada da classe Operacoes
        if(bitSinal1!=bitSinal2) {
        	binarioContador=IntSubtracao.complementoDeDois(binarioContador); //se os dois binarios tem sinais opostos, aplica complemento de dois sobre o resultado
        	String aux=new String(binarioContador);
        	aux="1"+aux;
        	binarioContador=aux.toCharArray();
        }else binarioContador[0]='0';
        return binarioContador;

    }

}
