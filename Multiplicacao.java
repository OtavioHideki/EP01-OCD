import java.util.Arrays;

public class Multiplicacao extends Operacoes {

	public Multiplicacao (){
		this.verbo = "multiplicar";
	}
	
	public char[] conta(char[] binario1, char[] binario2){
		Adicao add = new Adicao();
		Subtracao sub = new Subtracao();

		int tamanho = binario1.length+binario2.length+1;  //inteiro para passar o tamanho dos chars A,S,P.

		char[] A = new char[tamanho];
		char[] S = new char[tamanho];
		char[] P = new char[tamanho];

		for(int i = 0; i <tamanho; i++){
			A[i] = '0';	// A é o multiplicando (adição).
			S[i] = '0';	// S é o negativo do multiplicando(subtração).
			P[i] = '0';	// P é o produto.
		}

		for(int i = 0; i < binario1.length; i++){
			A[i] = binario1[i];	//passa o binario 1 para A.
		}

		char[] aux = sub.complementoDeDois(binario1); //Guarda o complemento de dois do binario1 no char auxiliar e depois passa para S.
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
		
		/*Função para verificar se os dois últimos bits de P são 00, 11, 01, 10 e assim determinar
		 * o que o algoritmo faz. */
		int compara = binario1.length; //variavel que sera usada de "parametro" para o for
		if(binario2.length<binario1.length) compara=binario2.length;
		for(int i = 0; i < compara; i++){
			//if(P[tamanho -2] == '0' && P[tamanho-1] == '0'){
				//Não faz nada
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
				//Não faz nada
			//}
			
			rightShift(P,tamanho);
			display(P, 'P');
		}
		return P;
	}
	
	/*Função para deslocar o os bits para a direita.*/
	public void rightShift(char[] A, int tamanho){
		for (int i = tamanho-1; i >= 1; i--){
			A[i] = A[i-1];
		}
	}
	
	/*Função para mostrar os passos do algoritmo na interface.*/
	public void display(char[] P, char ch){
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
	

