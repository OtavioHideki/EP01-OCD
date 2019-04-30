
public class FloatSubtracao extends Floats {
	
	public String conta(String binario1,String expoente1,String binario2,String expoente2) {
		FloatAdicao add=new FloatAdicao();
		char[] aux=binario2.toCharArray();
		aux=IntSubtracao.complementoDeDois(aux);
		binario2=new String(aux);
		if(bitSinal2.equals("0")) bitSinal2="1";
		else bitSinal2="0";
		String resultado=add.conta(binario1, expoente1, binario2, expoente2);
		return resultado;
	}

}
