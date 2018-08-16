/* animando a parada (tunts tunts) */

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class Animacao extends JFrame {
	private JPanel tela;
	private int fps = 1000 / 60;
	private int contador;
	private boolean animar = true;
	
	public void iniciarAnimacao()
	{
		long atualizacao = 0;
		
		while (animar)
		{
			if (System.currentTimeMillis() >= atualizacao) // tempo em milésimos de segundo
			{
				contador++; // responsável pela mudança na tela (tanto eixo quanto tamanho do desenho)
				tela.repaint();
				
				atualizacao = System.currentTimeMillis() + fps;
				
				if (contador == 200) { animar = false; }
			}
		}
	}
	
	public Animacao() {
		
		tela = new JPanel()	
		{
			public void paintComponent(Graphics lapis)
			{
				lapis.setColor(Color.decode("#F7F8F3"));
				lapis.fillRect(0, 0, tela.getWidth(), tela.getHeight()); // pinta background
								
				lapis.setColor(Color.decode("#F0A323"));
				lapis.drawRect(12, 40, 400 + contador, 170  + contador);
				
				lapis.setColor(Color.decode("#82486C"));
				lapis.setFont(new Font("Verdana", 1, 20));
				lapis.drawString("Score: " + contador, 55, 30);
			}
		};
		
		super.getContentPane().add(tela); // adiciona a tela à janela (ou moldura)		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480); // altura, largura
		setVisible(true);
		tela.repaint();
	}

	// main
	public static void main(String[] args)
	{ 
		Animacao anime = new Animacao();
		
		anime.iniciarAnimacao();
	}
}
