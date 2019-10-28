import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JogoBatalhaTerrestreComponente {
	private JFrame frame;
	private JLabel[][] grid;

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
		frame.setTitle("Matriz de Labels");
		frame.setBounds(100, 100, 402, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//inicializar a matriz de labels
		int n=10;
		grid = new JLabel[n][n];
		for(int y=0; y < n; y++){
			for(int x=0; x < n; x++){
				grid[x][y]=new JLabel(x+"-"+y);
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
						grid[indicex][indicey].setBackground(Color.BLUE);
						System.out.println("clicou na celula:"+  indicex + "-" + indicey);
					}
				});
			}
		}

	}


}
