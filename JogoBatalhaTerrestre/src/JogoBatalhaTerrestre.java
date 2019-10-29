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
			   
	    int cont = 0;
	    while (cont<=4) {
	    	int n1 = rand.nextInt(10);
		    int n2 = rand.nextInt(10);
	    	if(matriz[n1][n2]==0) {
	    		matriz[n1][n2]=1;
	    		cont++;
	    	}
	    	else {
	    		cont--;
				}
	    }
	}

	public String atirar(int linha, int coluna)  throws Exception {
		
		// verifica se a linha e a coluna são repetidas
		for(int i=0; i<getTiros(); i++){
				if(array_linha[i]==linha && array_coluna[i]==coluna){
					throw new Exception("Já atirou essa posição, escolha outra.");							
						}
				}
		
		//validar linha e coluna fora da faixa
		if(linha<0 || linha>9 || coluna<0 || coluna>9 ) {
			throw new Exception("o número da linha ou coluna esta fora da faixa permitida entre 0 e 9"); 
		}

		// Sendo linha e coluna válidas é possivel atirar
		
		FileWriter arq = new FileWriter("result.txt", true);
		BufferedWriter conexao = new BufferedWriter(arq);
		
		// Armazenando os locais que já atiraram

		array_linha[getTiros()]=linha;
		array_coluna[getTiros()]=coluna;
			
		if (matriz[linha][coluna]==1) {
				setAcertos(1);
				setTiros(1);
				
				// Salvando em arquivo texto
					conexao.write(linha+" "+coluna+" "+"Alvo");
					conexao.newLine();
					conexao.close();
					System.out.println("Alvo\n");
				return "Alvo\n";
			}
		else{
			setTiros(1);
			
			if (temAlvoPerto(linha,coluna)==true) {
				// Salvando em arquivo texto
					conexao.write(linha+" "+coluna+" "+"Próximo");
					conexao.newLine();
					conexao.close();
					System.out.println("Próximo\n");
				return "Próximo\n"; 
			}else {
				//Salvando em arquivo texto
					conexao.write(linha+" "+coluna+" "+"Distante");
					conexao.newLine();
					conexao.close();
					System.out.println("Distante\n");
				return "Distante\n";
			}
		}			
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
	
	private boolean temAlvoPerto(int linha, int coluna) {
		//verifica se existem alvos vizinhos ao tiro
		int soma =0;
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
		if(soma>=1) {
			return true;
		}
		else {
			return false;
		}
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
