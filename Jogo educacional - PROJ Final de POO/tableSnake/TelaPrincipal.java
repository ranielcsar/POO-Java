/*
# Jogo feito por:
#
# Raniel César (ranoob)
#
# Pode usar o código a vontade, mas não
# tire os créditos. :D
#
#
*/

package tableSnake;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private final Engine motor;
    private final Telas telas;
    private boolean travar = false;
    
    TelaPrincipal()
    {
        motor = createEngine();
        telas = new Telas();
        setPropriedades();
    }
    
    private Engine createEngine() 
    {        
        Container conteudo = getContentPane();
        Game jogo = new Game();
        Engine motor = new Engine(jogo);
        
        motor.setPreferredSize(new Dimension(Propriedades.LARGURA, Propriedades.ALTURA));
        
        addKeyListener(new Teclas());
        
        conteudo.add(motor);
        
        return motor;
    }
    
    private void setPropriedades() 
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TableSnake");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null); // centralizar tela
    }    
   
    protected void startGame(Engine motor) 
    {
        Thread processo = new Thread(motor);
        
        processo.start();
    }
    
    private class Engine extends JPanel implements Runnable {

        private static final long serialVersionUID = 1L;
        
        private final Game jogo;
        
        private Engine(Game game)
        {
           this.jogo = game;
        }        
        
        @Override
        protected void paintComponent(Graphics lapis)
        {            
            super.paintComponent(lapis);
            
            if (System.getProperty("os.name").equals("Linux"))
            {
                 Toolkit.getDefaultToolkit().sync();
            }
            
            setBackground(Propriedades.BG);
            
            switch (telas.getStatus())
            {
                case NAO_COMECOU:
                    telas.desenhaTitulo(lapis);
                    telas.desenhaInstrucoes(lapis);
                    break;                    
                case RODANDO:
                    jogo.pintar(lapis);
                    break;
                case PARADO:
                    jogo.pintar(lapis);
                    telas.desenhaPausa(lapis);
                    break;
                case GAMEOVER:
                    telas.desenhaGameOver(lapis);
                    motor.jogo.resetar();
                    travar = true;
                default:
                    break;
            }
        }        
        
        
        @Override
        public void run() 
        {            
            long lastTime = System.nanoTime();
            double tempoPassado = 0.0;
            double FPS = 20.0;
            
            // Game loop
            while (telas.getStatus() == Status.RODANDO)
            {
                long now = System.nanoTime();

                tempoPassado += ((now - lastTime) /  1_000_000_000.0) * FPS;

                if (tempoPassado >= 1)
                {
                    jogo.atualizar();                    
                    tempoPassado--;
                }

                sleep();

                repaint();
            }
        }
    }
    
    public void sleep() 
    {        
        try
        {
            Thread.sleep(95); // muda a velocidade da cobrinha. quanto maior o número, mais devagar
        } catch (InterruptedException exception) { }        
    }
    
    public class Teclas extends KeyAdapter {
       
        public boolean pause;
        
        @Override
        public void keyPressed(KeyEvent evento)
        {
            int tecla = evento.getKeyCode();
            
            if (telas.getStatus() == Status.RODANDO)
            {
                switch (tecla)
                {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                         motor.jogo.directionLeft();
                         break;

                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                         motor.jogo.directionRight();
                         break;

                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                         motor.jogo.directionUp();
                         break;

                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                         motor.jogo.directionDown();
                         break;
                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_P:
                        if (!pause)
                        {
                           telas.setStatus(Status.PARADO);
                           pause = true;
                        } else {
                           pause = false;
                        }
                        break;
                }
            }
            
            if (tecla == KeyEvent.VK_ENTER && telas.getStatus() == Status.NAO_COMECOU)
            {
                startGame(motor);
                telas.setStatus(Status.RODANDO);
            }
            
            if (tecla == KeyEvent.VK_ENTER && telas.getStatus() == Status.GAMEOVER)
            {
                motor.jogo.resetar();
            }
            
            if (tecla == KeyEvent.VK_P || tecla == KeyEvent.VK_SPACE && pause)
            {
                telas.setStatus(Status.RODANDO);              
                pause = false;
            }
        } 
    }    
    
    public static void main(String[] args)
    {
       TelaPrincipal tela = new TelaPrincipal();
    }
}