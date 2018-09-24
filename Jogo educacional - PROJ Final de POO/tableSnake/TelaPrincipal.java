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
    
    private Engine motor;
    private final Telas telas;
    
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
        
        private Game jogo;
        
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
                    telas.desenhaGameOver(lapis, motor.jogo.getAcertos(), motor.jogo.getErros(), motor.jogo.getScore());
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
                if (motor.jogo.getOver())
                {
                    telas.setStatus(Status.GAMEOVER);
                }
                
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
                    default:
                        break;
                }
            }
            
            if (tecla == KeyEvent.VK_ENTER)
            {
                if (telas.getStatus() == Status.NAO_COMECOU)
                {
                    startGame(motor);
                    telas.setStatus(Status.RODANDO);
                }
                
                if (telas.getStatus() == Status.GAMEOVER)
                {
                    motor.jogo.resetar();
                    telas.setStatus(Status.RODANDO);
                    startGame(motor);
                }
            }            
            
            if (tecla == KeyEvent.VK_P || tecla == KeyEvent.VK_SPACE)
            {
                if (telas.getStatus() != Status.GAMEOVER)
                {
                    switch (telas.getStatus())
                    {
                        case RODANDO:
                            telas.setStatus(Status.PARADO);                        
                            break;
                        case PARADO:
                            telas.setStatus(Status.RODANDO);
                            startGame(motor);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if (tecla == KeyEvent.VK_ESCAPE)
            {
                System.exit(0);
            }
        }
    }    
    
    public static void main(String[] args)
    {
       TelaPrincipal tela = new TelaPrincipal();
    }
}