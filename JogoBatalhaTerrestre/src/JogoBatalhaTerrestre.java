import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class JogoBatalhaTerrestre {
	private int tiros;
	private int acertos;
	private int [][] matriz;
	private int[] array_linha; 
	private int[] array_coluna;
	
	public JogoBatalhaTerrestre(){
		tiros = 0;
		acertos = 0;
		matriz = new int [10][10];
		array_linha = new int[20];
		array_coluna = new int[20];
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
			FileWriter arq = new FileWriter("result.txt", true);
			BufferedWriter conexao = new BufferedWriter(arq);
			
			if (matriz[linha][coluna]==1) {
				System.out.println("Alvo\n");
				setAcertos(1);
				setTiros(1);
				
				// Salvando em arquivo texto
				String linha0;
				linha0 = "Alvo";
				conexao.write(linha+" "+coluna+" "+linha0);
				conexao.newLine();
				conexao.close();
				
				
				// verifica se a linha e a coluna já foi acertada  
				if(!(array_linha==null)){
					for(int i=1; i<getTiros(); i++){
						if(array_linha[i]==linha && array_coluna[i]==coluna){
							setAcertos(-1);
							throw new Exception("Já acertou essa posição, escolha outra.");							
							}
					}
				}

				for(int i=getTiros(); i<=getTiros(); i++){
					array_linha[i]=linha;
					array_coluna[i]=coluna;
					}
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
					
					// Salvando em arquivo texto

					String linha1;
					linha1 = "Próximo de acertar o alvo";
					conexao.write(linha+" "+coluna+" "+linha1);
					conexao.newLine();
					conexao.close();
					}
				else {
					System.out.println("Distante\n");
					
					//Salvando em arquivo texto
					
					String linha2;
					linha2 = "Distante";
					conexao.write(linha+" "+coluna+" "+linha2);
					conexao.newLine();
					conexao.close();
					}
				
				// Armazenando os locais que já atiraram
				
				if(!(array_linha==null)){
					for(int i=1; i<getTiros(); i++){
						if(array_linha[i]==linha && array_coluna[i]==coluna){
							throw new Exception("Já atirou nessa posição, escolha outra.");
							}
					}
				}

				for(int i=getTiros(); i<=getTiros(); i++){
					array_linha[i]=linha;
					array_coluna[i]=coluna;
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
