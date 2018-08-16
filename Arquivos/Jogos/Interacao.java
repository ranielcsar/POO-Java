import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interacao extends JFrame {
	private JPanel tela;
	private int pontoX, pontoY;
	private boolean jogando = true;
	private boolean[] controleTecla = new boolean[4];
	
	private final int FPS = 1000 / 60;
	
	public void iniciar() {
		long atualizacao = 0;
		
		while (jogando)
		{
			if (System.currentTimeMillis() >= atualizacao) // tempo em milésimos de segundo
			{
				atualizaJogo();
				tela.repaint();
				
				atualizacao = System.currentTimeMillis() + FPS;				
			}
		}
	}
	
	private void atualizaJogo()
	{
		// X
		if (controleTecla[2])
		{
			pontoX--;
		} else if (controleTecla[3]) {
			pontoX++;
		}
		
		// Y
		if (controleTecla[0])
		{
			pontoY--;
		} else if (controleTecla[1]) {
			pontoY++;
		}	
	}
	
	private void setaTecla(int tecla, boolean pressionada)
	{
		switch (tecla) {
			case KeyEvent.VK_ESCAPE:
				jogando = false;
				break;
			case KeyEvent.VK_UP:
				controleTecla[0] = pressionada;
				break;
			case KeyEvent.VK_DOWN:
				controleTecla[1] = pressionada;
				break;
			case KeyEvent.VK_LEFT:
				controleTecla[2] = pressionada;
				break;
			case KeyEvent.VK_RIGHT:
				controleTecla[3] = pressionada;
				break;
		}
	}
	
	public Interacao() {		
		super.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent evento)
			{
				setaTecla(evento.getKeyCode(), true);
			}
			
			public void keyReleased(KeyEvent evento)
			{
				setaTecla(evento.getKeyCode(), false);
			}

			public void keyTyped(KeyEvent evento) {}
		});
		
		tela = new JPanel()	
		{
			public void paintComponent(Graphics lapis)
			{
				lapis.setColor(Color.decode("#382D36"));
				lapis.fillRect(0, 0, tela.getWidth(), tela.getHeight()); // pinta background
				
				// metade do tamanho da tela - metade do desenho
				int x = tela.getWidth() / 2 - 20 + pontoX;
				int y = tela.getHeight() / 2 - 20 + pontoY; 
				
				lapis.setColor(Color.decode("#F5B81D"));
				lapis.fillOval(x, y, 40, 40); // desenho
				
				lapis.setColor(Color.decode("#CC5760"));
				lapis.setFont(new Font("Verdana", 1, 20));
				lapis.drawString("Agora estou em " + "X: " + x + " Y: " + y, 10, 20);
			}
		};
		
		getContentPane().add(tela); // adiciona a tela à janela (ou moldura)		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480); // altura, largura
		setVisible(true);		
	}

	// main
	public static void main(String[] args)
	{ 
		Interacao jogo = new Interacao();
		
		jogo.iniciar();
	}
}