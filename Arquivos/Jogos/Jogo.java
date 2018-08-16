/* Jogo criado com base no livro "Lógica do jogo - recriando clássicos 

  - Raniel (ranoob)
  - 16 ago. 2018.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Jogo extends JFrame {
	private final int FPS = 1000 / 30;
	
	// classe com propriedades principais de elementos
	class Elemento {
		public int x, y, largura, altura;
		public float velocidade;
		
		public Elemento(int x, int y, int largura, int altura) {
			this.x = x;
			this.y = y;
			this.largura = largura;
			this.altura = altura;
		}
	}
	
	private JPanel tela;
	private boolean jogando = true;
	private boolean gameOver = false;
	
	private Elemento tiro;
	private Elemento jogador;
	private Elemento[] blocos;
	
	private int pontos;
	private int pixels = 40;
	private int linhaLimite = 350;
	private Random numeroAleatorio = new Random();
	
	private boolean[] teclas = new boolean[4];
	
	private void setaTecla(int tecla, boolean pressionada)
	{
		switch (tecla) {
			case KeyEvent.VK_ESCAPE:
				jogando = false;
				break;
			case KeyEvent.VK_UP: case KeyEvent.VK_W:
				teclas[0] = pressionada;
				break;
			case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
				teclas[1] = pressionada;
				break;
			case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
				teclas[2] = pressionada;
				break;
			case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
				teclas[3] = pressionada;
				break;
		}
	}
	
	public Jogo() {
		this.addKeyListener(new KeyListener()
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
		
		tiro = new Elemento(0, 10, 3, 0);
		jogador = new Elemento(0, 0, pixels, pixels);
		jogador.velocidade = 5;
		
		blocos = new Elemento[5];
		for (int i = 0; i < blocos.length; i++)
		{
			int espaco = i * pixels + 10 * (i + 1);
			
			blocos[i] = new Elemento(espaco, 0, pixels, pixels);
			blocos[i].velocidade = 1;
		}
		
		// tela
		tela = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics lapis)
			{
				lapis.setColor(Color.decode("#383234"));
				lapis.fillRect(0, 0, tela.getWidth(), tela.getHeight());
				
				lapis.setColor(Color.decode("#85AFB7"));
				lapis.fillRect(tiro.x, tiro.y, tiro.largura, tela.getHeight());
				
				lapis.setColor(Color.decode("#F6F6E8"));
				lapis.fillRect(jogador.x, jogador.y, jogador.altura, jogador.largura);
				
				lapis.setColor(Color.decode("#B63B50"));
				for (Elemento bloco : blocos)
				{
					lapis.fillRect(bloco.x, bloco.y, bloco.largura, bloco.altura);
				}
				
				lapis.setColor(Color.GRAY);
				lapis.drawLine(0, linhaLimite, tela.getWidth(), linhaLimite);
				
				lapis.setColor(Color.decode("#E9DD3E"));
				lapis.setFont(new Font("Verdana", 1, 15));
				lapis.drawString("Pontos: " + pontos, 10, 15);
			}
		};
		
		getContentPane().add(tela);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		jogador.x = tela.getWidth() / 2 - jogador.x / 2;
		jogador.y = tela.getHeight() - jogador.altura + 10;
		tiro.altura = tela.getHeight() - jogador.altura;
	}
	
	private void atualizar() {
		if (gameOver) return;
		
		if (teclas[2])
		{
			jogador.x -= jogador.velocidade;
		} else if (teclas[3]) {
			jogador.x += jogador.velocidade;
		}
		
		if (jogador.x < 0)
		{
			jogador.x = tela.getWidth() - jogador.largura;
		}
		
		if (jogador.x + jogador.largura > tela.getWidth())
		{
			jogador.x = 0;
		}
		
		tiro.y = 0;
		tiro.x = jogador.x + jogador.largura / 2;
		
		// colisões
		for (Elemento bloco : blocos)
		{
			if (bloco.y > linhaLimite)
			{
				gameOver = true;
				break;
			}
			
			if (colisao(bloco, tiro) && bloco.y > 0)
			{
				bloco.y -= bloco.velocidade * 2;
				tiro.y = bloco.y;
			} else {
				int sorte = numeroAleatorio.nextInt(10);
				
				if (sorte == 0)
				{
					bloco.y += bloco.velocidade + 1;
				} else if (sorte == 5) {
					bloco.y -= bloco.velocidade;
				} else {
					bloco.y += bloco.velocidade;
				}
			}
		}
		
		pontos = pontos + blocos.length;
	}
	
	public boolean colisao(Elemento A, Elemento B)	{
		
		if (A.x + A.largura >= B.x && A.x <= B.x + B.largura)
			return true;
		
		return false;
	}
	
	public void iniciar() {
		long atualizacao = 0;
		
		while (jogando)
		{
			if (System.currentTimeMillis() >= atualizacao) // tempo em milésimos de segundo
			{
				atualizar();
				tela.repaint();
				
				atualizacao = System.currentTimeMillis() + FPS;				
			}
		}
	}
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		
		jogo.iniciar();
	}
}
