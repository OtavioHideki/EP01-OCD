
public class Divisao extends Operacoes {
    static char[] resto;

    Divisao(){
        this.verbo="dividir";
        Operacoes.divisao=true;
    }
    char[] conta(char[] binario1, char[] binario2){
        char bitSinal1=binario1[0];
        if(bitSinal1=='1') {
           binario1=Subtracao.complementoDeDois(binario1);
        }
        char bitSinal2=binario2[0];
        if(bitSinal2=='1') {
            binario2=Subtracao.complementoDeDois(binario2);
        }
        String aux1=new String(binario2);
        char[] aux2=aux1.toCharArray();
        Subtracao sub=new Subtracao();
        Adicao add=new Adicao();
        resto=sub.conta(binario1,aux2);
        int contador=1;
        while(!negativo){
            contador++;
            aux2=aux1.toCharArray();
            char[] binario3=resto;
            resto=sub.conta(binario3,aux2);
        }
        aux2=aux1.toCharArray();
        resto=add.conta(resto,aux2);
        contador--;
        int i=max-1;
        char[] binarioContador=new char[max];
        while(contador/2!=0&&i>0){
            binarioContador[i]=Character.forDigit(contador%2,10);
            contador=contador/2;
            i--;

        }
        binarioContador[i]=Character.forDigit(contador,10);
        parada=i-1;
        if(bitSinal1!=bitSinal2) binarioContador=Subtracao.complementoDeDois(binarioContador);
        else binarioContador[0]='0';
        return binarioContador;

    }

}
