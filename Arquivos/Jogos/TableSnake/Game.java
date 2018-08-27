package cobrinha;

import java.awt.*;
import java.util.Random;

public class Game {

    private Elemento comida;
    private Snake cobra;
    private int score = 0;

    private Direction movimento = Direction.BAIXO;
    private Direction lastMove = movimento;

    Game()
    {        
        this.cobra = new Snake();
        novaComida();
        atualizar();
    }

    void atualizar() { moverCobra(); }

    void novaComida()
    {        
        Random rX = new Random();
        Random rY = new Random();
        
        comida = new Elemento(Elemento.Tipo.COMIDA,
        rX.nextInt(Propriedades.COL), rY.nextInt(Propriedades.ROW));
        
        if (cobra.contains(comida)) { novaComida(); }
    }

    void directionLeft()
    {        
        if (lastMove != Direction.DIREITA)
        {
            movimento = Direction.ESQUERDA;
        }
    }

    void directionRight() 
    {
        if (lastMove != Direction.ESQUERDA)
        {
            movimento = Direction.DIREITA;
        }
    }

    void directionUp()
    {        
        if (lastMove != Direction.BAIXO)
        {
            movimento = Direction.CIMA;
        }
    }

    void directionDown()
    {        
        if (lastMove != Direction.CIMA)
        {
            movimento = Direction.BAIXO;
        }
    }


    private void moverCobra()
    {        
        if (movimento == Direction.ESQUERDA)
        {
            moveSnakeLeft();
        } else if (movimento == Direction.DIREITA) {
            moveSnakeRight();
        } else if (movimento == Direction.CIMA) {
            moveSnakeUp();
        } else if (movimento == Direction.BAIXO) {
            moveSnakeDown();
        }

        lastMove = movimento;
    }

     private void moveSnakeLeft()
     {         
         if (!cobra.moveLeft()) { sair(); }
         
         checaParedes();
         checarSeComeu();
         
         movimento = Direction.ESQUERDA;
     }
     
     private void moveSnakeRight()
     {         
         if (!cobra.moveRight()) { sair(); }
         
         checaParedes();
         checarSeComeu();
         
         movimento = Direction.DIREITA;
     }
     
     private void moveSnakeUp()
     {         
         if (!cobra.moveUp()) { sair(); }
         
         checaParedes();
         checarSeComeu();
         
         movimento = Direction.CIMA;
     }
     
     private void moveSnakeDown()
     {         
         if (!cobra.moveDown()) { sair(); }
         
         checaParedes();
         checarSeComeu();
         
         movimento = Direction.BAIXO;
     }
     
     
     private void checaParedes()
     {         
         Elemento kbca = cobra.getHead();
         
         boolean esquerda = kbca.getX() < 0;
         boolean direita = kbca.getX() >= Propriedades.COL;
         boolean cima = kbca.getY() < 0;
         boolean baixo = kbca.getY() >= Propriedades.ROW;
         
         boolean fora = esquerda || direita || cima || baixo;
         
         if (fora) { sair(); }
     }
     
     private void checarSeComeu()
     {         
         if (comeu())
         {
             aumentarCobra();
             novaComida();
         }
     }
     
     private void sair()
     {
        System.out.println("Pontuação final: " + getScore());
        System.exit(0);
     }
     
     int getScore() { return score; }
     
     private boolean comeu() { return cobra.getHead().igual(comida); }
     
     private void aumentarCobra()
     {         
        cobra.crescer();
        score += 5;
     }
     
     void pintar(Graphics g)
     {         
         Graphics2D lapis = (Graphics2D) g;
         
         lapis.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         
         pintarCobra(lapis);
         pintarComida(lapis);
         score(lapis);
     }
     
     void pintarCobra(Graphics2D lapis)
     {         
         int x, y;
         int cantos = Propriedades.PIXELS / 3;
         
         for (Elemento element : cobra)
         {
             x = element.getX() * Propriedades.PIXELS;
             y = element.getY() * Propriedades.PIXELS;
             
             int xHead = cobra.getHead().getX() * Propriedades.PIXELS;
             int yHead = cobra.getHead().getY() * Propriedades.PIXELS;
             
             lapis.setColor(Propriedades.SNAKE);
             lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);
             
             lapis.setColor(Propriedades.HEADcor);
             lapis.fillRoundRect(xHead + 1, yHead + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);             
         }
     }
     
     void pintarComida(Graphics2D lapis)
     {         
         int x = comida.getX() * Propriedades.PIXELS;
         int y = comida.getY() * Propriedades.PIXELS;
         int cantos = Propriedades.PIXELS / 3;
         
         Random numero = new Random();
         
         lapis.setColor(Propriedades.FOOD);      
         lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);
         lapis.setColor(Color.white);
         lapis.setFont(new Font("Verdana", 1, 20));
         lapis.drawString(Integer.toString(numero.nextInt(10)), x + 8, y + 22);
     }
     
     void score(Graphics2D lapis)
     {
    	 lapis.setColor(Color.decode("#efd19f"));
    	 lapis.setFont(new Font("Verdana", 1, 20));
    	 lapis.drawString("Pontuação: " + getScore(), 20, 40);
     }
}