package tableSnake;

import java.awt.*;
import java.util.Random;

public class Game {

    private Elemento comida;
    private final Snake cobra;
    private final Matematica math = new Matematica();
    private int score = 0;
    private int numeroRandom = 0;
    private int numero = 0;
    private int resultado = 0;
    private int contadora = 0;

    private boolean hasNumber = false;
    
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
        Random random = new Random();
        
        numeroRandom = random.nextInt(10);
        
        comida = new Elemento(Elemento.Tipo.COMIDA,
        rX.nextInt(Propriedades.COL), rY.nextInt(Propriedades.ROW), numeroRandom);
        
        if (cobra.contains(comida)) { novaComida(); }
    }
    
    public Elemento getComida() { return comida; }

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
    	switch (movimento)
    	{
    		case ESQUERDA:
    			moveSnakeLeft();
    			break;
    		case DIREITA:
    			moveSnakeRight();
    			break;
    		case CIMA:
    			moveSnakeUp();
    			break;
    		case BAIXO:
    			moveSnakeDown();
    			break;
    		default:
    			break;
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
            numero = comida.getNumero();
            
            aumentarCobra();
            novaComida();        
            adicionarNumeros();
            
            contadora++;
        }
        
        if (contadora == 2)
        {
            resultado = math.multiplicar();
            contadora = 0;
        }
    }

    private void sair()
    {
       System.out.println("Pontuação final: " + getScore());
       System.exit(0);
    }

    int getScore() { return score; }

    public boolean comeu() { return cobra.getHead().igual(comida); }

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
        desenhaPainel(lapis);
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

            lapis.setColor(Propriedades.HEAD);
            lapis.fillRoundRect(xHead + 1, yHead + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);             
        }
    }
     
     void pintarComida(Graphics2D lapis)
     {
         int x = comida.getX() * Propriedades.PIXELS;
         int y = comida.getY() * Propriedades.PIXELS;
         int cantos = Propriedades.PIXELS / 3;         
         
         lapis.setColor(Propriedades.FOOD);      
         lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);         
        
    	 lapis.setColor(Color.WHITE);
         lapis.setFont(new Font("Verdana", 1, 20));
         lapis.drawString(Integer.toString(comida.getNumero()), x + 8, y + 23);        
     }
     
    public void desenhaPainel(Graphics2D lapis)
    {    	 
        lapis.setColor(Color.white);
        lapis.drawRoundRect(480, 20, 300, 60, 20, 20);
        lapis.setFont(new Font("Verdana", 1, 45)); 		

        lapis.drawString(Integer.toString(math.getNumero1()), 490, 67);
        lapis.drawString("x", 550, 65); 	 		
        lapis.drawString(Integer.toString(math.getNumero2()), 610, 67);
        lapis.drawString("=", 660, 67);
        lapis.drawString(Integer.toString(resultado), 710, 67);
    }
     
    void score(Graphics2D lapis)
    {
        lapis.setColor(Color.decode("#efd19f"));
        lapis.setFont(new Font("Verdana", 1, 25));
        lapis.drawString("Pontuação: " + getScore(), 20, 40);
    }    
     
    public void adicionarNumeros()
    {
    	if (!hasNumber)
        {
            math.setNumero1(numero);
            hasNumber = true;    		
        } else {
            math.setNumero2(numero);
            hasNumber = false;
        }
    }
}
