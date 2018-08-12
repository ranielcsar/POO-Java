import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Janela extends JFrame {
	private JPanel tela;
	private int fps = 1000 / 20;
	private int contador;
	private boolean animar = true;
	
	public Janela()
	{
		tela = new JPanel()
		{
			public void paintComponent(Graphics lapis)
			{
				lapis.setColor(Color.decode("#272121"));
				lapis.drawLine(320, 0, 320, 480); // x, y (coordenadas); posições finais de x e y
				lapis.drawLine(0, 240, 640, 240);
				lapis.drawRect(10, 25, 20, 20);
				lapis.drawOval(40, 20, 40, 30); //x , y (coordenadas); altura e largura
				
				lapis.setColor(Color.decode("#281B2C"));				
				lapis.fillRect(95, 200, 160, 30);
				lapis.fillOval(380, 130, 120, 120); 
				
				lapis.setColor(Color.decode("#719FBF"));
				lapis.drawString("Olá mundo dos gráficos! :D", 100, 220);
			}
		};
		
		super.getContentPane().add(tela); // adiciona a tela à janela (ou moldura)
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480); // altura, largura
		setVisible(true);
		tela.repaint();
	}
	
	// main
	public static void main(String[] args) { new Janela(); }
}