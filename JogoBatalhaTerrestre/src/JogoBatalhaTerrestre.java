import java.util.Random;

public class JogoBatalhaTerrestre {
	private int tiros;
	private int acertos;
	private int [][] matriz;
	private int num;
	public JogoBatalhaTerrestre(){
		tiros = 0;
		acertos = 0;
		matriz = new int [10][10];
		Random rand = new Random();
		int n1 = rand.nextInt(10);
	    int n2 = rand.nextInt(10);
	    int n3 = rand.nextInt(10);
	    int n4 = rand.nextInt(10);
	    int n5 = rand.nextInt(10);
	    int n6 = rand.nextInt(10);
	    int n7 = rand.nextInt(10);
	    int n8 = rand.nextInt(10);
	    int n9 = rand.nextInt(10);
	    int n10 = rand.nextInt(10);
		matriz[n1][n2] = 1;
		matriz[n3][n4] = 1;
		matriz[n5][n6] = 1;
		matriz[n7][n8] = 1;
		matriz[n9][n10] = 1;
		System.out.println("_____Alvos_____");
		System.out.println("Linha: "+n1+" "+"Coluna: "+n2);
		System.out.println("Linha: "+n3+" "+"Coluna: "+n4);
		System.out.println("Linha: "+n5+" "+"Coluna: "+n6);
		System.out.println("Linha: "+n7+" "+"Coluna: "+n8);
		System.out.println("Linha: "+n9+" "+"Coluna: "+n10);
	}

	public String atirar(int linha, int coluna)  throws Exception {
		//validar linha e coluna fora da faixa
		if(linha<0 || linha>10 && coluna<0 || coluna>10 ) {
			throw new Exception("o número da linha ou coluna esta fora da faixa permitida entre 0 e 10"); 
		}

		// Sendo linha e coluna válidas pode atirar
		else{
			if (matriz[linha][coluna]==1) {
				System.out.println("Alvo");
				setAcertos(1);
				setTiros(1);

			else{
				setTiros(1);
				if (matriz[linha+1][coluna+1]==1|| matriz[linha-1][coluna-1]==1||matriz[linha+1][coluna-1]==1||matriz[linha-1][coluna+1]==1||matriz[linha][coluna+1]==1||matriz[linha][coluna-1]==1||matriz[linha+1][coluna]==1||matriz[linha-1][coluna]==1) {
					System.out.println("Próximo");
				}
				else {
				System.out.println("Distante");
				}
			}				
		}
		return null;
	}
	public int getAcertos() {
		return acertos;
	}
	
	public int getTiros() {
		return tiros;
	}
	
	private void setAcertos(int acertos) {
		this.acertos += acertos;
	
	}

	private void setTiros(int tiros){
		this.tiros += tiros;
	}

	public boolean terminou() {
		if (getTiros() <= 20 && getAcertos() < 5) {
			return false;
		}
		return true;
		
	}
	
	public String toString() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10;j++) {
				System.out.println(matriz[i][j]+" ");
				}
		}
		return null;
	}
	
	public String getResultadoFinal() {
		if(terminou()) { 
			if (getAcertos()==5) {
				return "Você ganhou!!"; 
			}
			else
				return "Você perdeu!!";
		}
		else
			return "jogo ainda em execução";
	}
}