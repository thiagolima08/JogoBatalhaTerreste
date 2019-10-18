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
		if(linha<0 || linha>10 && coluna<0 || coluna>10 ) 
			throw new Exception("o numero da linha ou coluna esta fora da faixa permitida entre 0 e 10");
		return "tente novamente"; 
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	public int getTiros() {
		return tiros;
	}
	
	public boolean terminou() {
		if (tentativas <= 20 && getAcertos() < 5) {
			return false;
		}
		return true;
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


