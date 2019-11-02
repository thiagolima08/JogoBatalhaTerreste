import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import javax.swing.JButton;


public class JogoBatalhaTerrestreComponente {
	private JFrame frame;
	private JLabel[][] grid;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton button;
	private JogoBatalhaTerrestre jogo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoBatalhaTerrestreComponente window = new JogoBatalhaTerrestreComponente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JogoBatalhaTerrestreComponente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Batalha Terrestre");
		frame.setBounds(100, 100, 601, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Acertos:");
		label.setBounds(457, 58, 61, 16);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Tiros: ");
		label_1.setBounds(467, 86, 41, 16);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("0");
		label_2.setBounds(530, 58, 38, 16);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("0");
		label_3.setBounds(530, 86, 21, 16);
		frame.getContentPane().add(label_3);
		
		button = new JButton("Iniciar/Reiniciar");
		button.setBounds(434, 346, 134, 29);
		frame.getContentPane().add(button);
		
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				jogo = new JogoBatalhaTerrestre();
				//inicializar a matriz de labels
				int n=10;
				grid = new JLabel[n][n];
				for(int y=0; y < n; y++){
					for(int x=0; x < n; x++){
						grid[x][y]=new JLabel();
						frame.getContentPane().add(grid[x][y]);
						grid[x][y].setBounds(x*40, y*40, 40, 40);	//x,y, width, height - 40x40
						grid[x][y].setBackground(Color.BLACK);
						grid[x][y].setHorizontalAlignment(SwingConstants.CENTER);
						grid[x][y].setVerticalAlignment(SwingConstants.CENTER);
						grid[x][y].setBorder(new LineBorder(Color.WHITE, 1, true)); //arredondado
						grid[x][y].setOpaque(true);
						
						
						grid[x][y].addMouseListener(new  MouseAdapter(){
							public void mouseClicked(MouseEvent e){		//click
								JLabel b = (JLabel)e.getSource();
								int indicex = b.getX()/40;
								int indicey = b.getY()/40;
					
								try {		
									if (jogo.getResultadoFinal()=="Você ganhou!!") {
										JOptionPane.showMessageDialog(null,"Você ganhou!!");
									}
									if (jogo.getResultadoFinal()=="Você perdeu!!") {
										JOptionPane.showMessageDialog(null,"Você perdeu!!");
									}
									String jogar = jogo.atirar(indicey, indicex);
									if(jogar=="Alvo\n") {
										grid[indicex][indicey].setBackground(Color.RED);
										System.out.println("clicou na celula:"+  indicey + "-" + indicex);
									}else if(jogar=="Próximo\n"){
										grid[indicex][indicey].setBackground(Color.BLUE);
										System.out.println("clicou na celula:"+  indicey + "-" + indicex);
									}else{
										grid[indicex][indicey].setBackground(Color.YELLOW);
										System.out.println("clicou na celula:"+  indicey + "-" + indicex);
									};
								} catch (Exception e1) {
									System.out.println(e1.getMessage());
								}		
								
								label_2.setText(String.valueOf(jogo.getAcertos()));
								label_3.setText(String.valueOf(jogo.getTiros()));
							}
						});
					}
				}
			}
		});
	}
}
