import java.util.Random;

public class JogoBatalhaTerrestre {
	private int tiros;
	private int acertos;
	private int [][] matriz;
	
	public JogoBatalhaTerrestre(){
		tiros = 0;
		acertos = 0;
		matriz = new int [10][10];
		Random rand = new Random();
		int n1 = rand.nextInt(10);
	    int n2 = rand.nextInt(10);
	   
	    int cont = 0;
	    while (cont<=4) {
	    	if(matriz[n1][n2]==0) {
	    		matriz[n1][n2]=1;
	    	}else {
	    		n1 = rand.nextInt(10);
				n2 = rand.nextInt(10);
				if(matriz[n1][n2]==0) {
		    		matriz[n1][n2]=1;
				}else {
		    		n1 = rand.nextInt(10);
					n2 = rand.nextInt(10);
					matriz[n1][n2]=1;
					}
	    	}
	    	cont++;
	    }
	}

	public String atirar(int linha, int coluna)  throws Exception {
		//validar linha e coluna fora da faixa
		if(linha<0 || linha>9 || coluna<0 || coluna>9 ) {
			throw new Exception("o número da linha ou coluna esta fora da faixa permitida entre 0 e 9"); 
		}

		// Sendo linha e coluna válidas pode atirar
		else{
			if (matriz[linha][coluna]==1) {
				System.out.println("Alvo\n");
				setAcertos(1);
				setTiros(1);
				}
			else{
				setTiros(1);
				int soma=0;
				//verifica se existem alvos vizinhos ao tiro
				if (linha==9&&coluna==9) {
					for(int i=linha-1;i<linha+1;i++) {
						for(int j=coluna-1;j<coluna+1;j++) {
							if (matriz[i][j]==1) {
								soma++;							
								}
							}
						}
				}else if(linha==0&&coluna==0){
					for(int i=linha;i<linha+2;i++) {
						for(int j=coluna;j<coluna+2;j++) {
							if (matriz[i][j]==1) {
								soma++;							
							}
						}
					}
				}
				else {
					if (linha==9||coluna==0) {
						for(int i=linha-1;i<linha+1;i++) {
							for(int j=coluna;j<coluna+2;j++) {
								if (matriz[i][j]==1) {
									soma++;							
									}
								}
							}
					}else if(linha==0||coluna==9){
						for(int i=linha;i<linha+2;i++) {
							for(int j=coluna-1;j<coluna+1;j++) {
								if (matriz[i][j]==1) {
									soma++;							
								}
							}
						}
					}
					else {
					for(int i=linha-1;i<linha+2;i++) {
						for(int j=coluna-1;j<coluna+2;j++) {
							if (matriz[i][j]==1) {
								soma++;							
								}
							}
						}
					}
				}
				
				//quantidade de alvos próximos ao tiro
				if(soma>=1) {
					System.out.println("Próximo de acertar "+soma+" dos alvos\n");
					}
				else {
					System.out.println("Distante\n");
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
		if (getTiros() < 20 && getAcertos() < 5) {
			return false;
		}
		return true;
		
	}
	
	public String toString() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10;j++) {
				System.out.print(matriz[i][j]+"\t");
				}
			System.out.println();
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
