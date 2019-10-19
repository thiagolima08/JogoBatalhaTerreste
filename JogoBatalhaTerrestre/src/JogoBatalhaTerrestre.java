import java.util.Random;

public class JogoBatalhaTerrestre {
	private int tiros;
	private int acertos;
	private final int tentativas;
	private int [][] matriz;
	
	public JogoBatalhaTerrestre(){
		tentativas = 0;
		tiros = 0;
		acertos = 0;
		matriz = new int [10][10];
		Random rand = new Random();
		int n = rand.nextInt(10);
	}

	public String atirar(int linha, int coluna)  throws Exception {
		//validar linha e coluna fora da faixa
		if(linha<0 || linha>10 && coluna<0 || coluna>10 ) {
			throw new Exception("o número da linha ou coluna esta fora da faixa permitida entre 0 e 10");
		return "tente novamente"; 
		}

		// Sendo linha e coluna válidas pode atirar
		else{
			matriz[linha][coluna] = '*'
		}
	}
	public int getAcertos() {
		return acertos;
	}
	
	public int getTiros() {
		return tiros;
	}
	
	public int getTentativas(){
		return tentativas;
	}
	
	public void setAcertos() {
		acertos = acertos + 1;
		setTentativas() 
	
	}

	public void setTentativas(){
		tentativas = tentativas + 1;
	}

	public void setTiros(){
		tiros = tiros + 1;
	}

	public boolean terminou() {
		if (getTentativas() <= 20 && getAcertos() < 5) {
			return false;
		}
		else if(getTentativas() > 20 || getAcertos() == 5){
			return true;
		}
		
	}
	
	public String getResultadoFinal() {
		if(terminou()) { 
			if (getAcertos()==5) {
				return "Voce ganhou!!"; 
			}
			else
				return "Voce perdeu!!";
		}
		else
			return "jogo ainda em execucao";
	}
}


