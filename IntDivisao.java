
public class IntDivisao extends Inteiros {
    static char[] resto;

    /*construtor que troca o verbo por dividir e confirma que está sendo feita uma divisão*/
    IntDivisao(){
        this.verbo="dividir";
        Inteiros.divisao=true;
    }
    /*faz a divisão*/
    char[] conta(char[] binario1, char[] binario2){
        char bitSinal1=binario1[0];

        /*aplica complemento de dois em cima do binário que for negativo*/
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
        int contador=1; //contador que verificará quantas subtrações foram feitas

        /*subtrai divisor do dividendo até o resto ser negativo*/
        while(!negativo){
            contador++;
            aux2=aux1.toCharArray();
            char[] binario3=resto;
            resto=sub.conta(binario3,aux2);
        }
        aux2=aux1.toCharArray();
        resto=add.conta(resto,aux2); //soma o divisor ao dividendo para achar o resto
        contador--; //diminui o contador em 1 pois foi feita uma subtração a mais
        int i=max-1;
        char[] binarioContador=new char[max];

        /*transforma o contador em binario*/
        while(contador/2!=0&&i>0){
            binarioContador[i]=Character.forDigit(contador%2,10);
            contador=contador/2;
            i--;

        }
        binarioContador[i]=Character.forDigit(contador,10);
        parada=i-1; //atualiza a variável parada da classe Operacoes
        if(bitSinal1!=bitSinal2) binarioContador=IntSubtracao.complementoDeDois(binarioContador); //se os dois binarios tem sinais opostos, aplica complemento de dois sobre o resultado
        else binarioContador[0]='0';
        return binarioContador;

    }

}
