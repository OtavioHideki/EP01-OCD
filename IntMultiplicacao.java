
public class IntMultiplicacao extends Inteiros {
	static boolean mult=false;
    IntMultiplicacao (){
        this.verbo = "multiplicar";
    }

    public char[] conta(char[] binario1, char[] binario2){
        IntAdicao add = new IntAdicao();
        int tamanho = binario1.length+binario2.length+1;  //inteiro para passar o tamanho dos chars A,S,P.

        char[] A = new char[tamanho];
        char[] S = new char[tamanho];
        char[] P = new char[tamanho];

        for(int i = 0; i <tamanho; i++){
            A[i] = '0';	// A eh o multiplicando (adicao).
            S[i] = '0';	// S eh o negativo do multiplicando(subtracao).
            P[i] = '0';	// P eh o produto.
        }

        for(int i = 0; i < binario1.length; i++){
            A[i] = binario1[i];
        }

        char[] aux = IntSubtracao.complementoDeDois(binario1); //Guarda o complemento de dois do binario1 no char auxiliar e depois passa para S.
        for(int i = 0; i < binario1.length; i++){
            S[i] = aux[i];
        }

        for(int i = 0; i < binario2.length; i++){
            int j = binario1.length;
            P[i+j] = binario2[i];
        }

        display(A, 'A');
        display(S, 'S');
        display(P, 'P');
        System.out.println();

        /*Funcao para verificar se os dois ultimos bits de P sao 00, 11, 01, 10 e assim determinar
         * o que o algoritmo faz. */
        int compara=binario2.length;
        for(int i = 0; i < compara; i++){
            //if(P[tamanho -2] == '0' && P[tamanho-1] == '0'){
            //Nao faz nada
            //}
            if(P[tamanho-2] == '1' && P[tamanho-1] == '0'){
                max=tamanho;
                P = add.conta(P,S);
            }
            if(P[tamanho-2] == '0' && P[tamanho-1] == '1'){
                max=tamanho;
                P = add.conta(P,A);
            }
            //if(P[tamanho -2] == '1' && P[tamanho -1] == '1'){
            //Nao faz nada
            //}

            rightShift(P,tamanho);
            display(P, 'P');
            System.out.println();
        }

        /*Funcao para printar a resposta sem o ultimo bit que serve apenas para auxilio do algoritmo de Booth*/
        char[] resposta = new char[tamanho-1];
        for (int i = 0; i < tamanho-1; i++){
            resposta[i] = P[i];
        }

        return resposta;
    }

    /*Funcao para deslocar os bits para a direita.*/
    public void rightShift(char[] A, int tamanho){
        for (int i = tamanho-1; i >= 1; i--){
            A[i] = A[i-1];
        }
    }

    /*Funcao para mostrar os passos do algoritmo na interface.*/
    private void display(char[] P, char ch){
        System.out.print("\n"+ch+" : ");
        for(int i = 0; i < P.length; i++){
            if (i == P.length/2)
                System.out.print(" ");
            if(i == P.length -1)
                System.out.print(" ");
            System.out.print(P[i]);
        }
    }
}