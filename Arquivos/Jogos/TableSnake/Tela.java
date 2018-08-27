package cobrinha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tela extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private Engine motor;
    
    private Tela() 
    {
        motor = createEngine();
        setPropriedades();
    }
    
    private Engine createEngine() 
    {        
        Container conteudo = getContentPane();
        Game jogo = new Game();
        Engine motor = new Engine(jogo);
        
        int canvasLargura = Propriedades.PIXELS * Propriedades.COL;
        int canvasAltura = Propriedades.PIXELS * Propriedades.ROW;
        
        motor.setPreferredSize(new Dimension(canvasLargura, canvasAltura));
        
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
    
    public void startGame(Engine motor) 
    {
        Thread processo = new Thread(motor);
        
        processo.start();
    }
    
    
    
    private class Engine extends JPanel implements Runnable {

        private static final long serialVersionUID = 1L;
        
        private Game jogo;      
        private boolean rodando = false;
        
        private Engine(Game game) { this.jogo = game; }
        
        
        protected void paintComponent(Graphics lapis)
        {            
            super.paintComponent(lapis);
            
            if (System.getProperty("os.name").equals("Linux"))
            {
                 Toolkit.getDefaultToolkit().sync();
            }
            
            setBackground(Propriedades.BG);
            jogo.pintar(lapis);
        }
        
        public void run() 
        {            
            long lastTime = System.nanoTime();
            double tempoPassado = 0.0;
            double FPS = 20.0;
            
            // Game loop
            while (true)
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
            Thread.sleep(90); // muda a velocidade da cobrinha
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }       
    
    
    public class Teclas extends KeyAdapter {
        
        public void keyPressed(KeyEvent evento)
        {            
            if (!motor.rodando)
            {
                startGame(motor);
                motor.rodando = true;
            }
            
            if (evento.getKeyCode() == KeyEvent.VK_LEFT)
            {
                motor.jogo.directionLeft();
            } else if (evento.getKeyCode() == KeyEvent.VK_RIGHT) {
                motor.jogo.directionRight();
            } else if (evento.getKeyCode() == KeyEvent.VK_UP) {
                motor.jogo.directionUp();
            } else if (evento.getKeyCode() == KeyEvent.VK_DOWN) {
                motor.jogo.directionDown();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new Tela();
    }
}