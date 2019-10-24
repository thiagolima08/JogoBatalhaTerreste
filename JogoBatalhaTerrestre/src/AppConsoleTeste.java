import java.util.Scanner;

public class AppConsoleTeste {

	public static void main(String[] args) {
		int linha;
		int coluna;
		Scanner teclado = new Scanner(System.in);
		JogoBatalhaTerrestre jogo = new JogoBatalhaTerrestre();
		do{
			System.out.println("\nDigite o número da linha: ");
			linha = teclado.nextInt();
			System.out.println("\nDigite o número da coluna: ");
			coluna = teclado.nextInt();	
			System.out.println();
			try {
				jogo.atirar(linha,coluna);
				} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				}
		}while(!jogo.terminou());
		System.out.println();
		System.out.println(jogo.getResultadoFinal());
		System.out.println(jogo.getAcertos()+" Acertos");
		System.out.println(jogo.getTiros()+" Tiros");
		System.out.println("\nGAME OVER !!");
	}
}
