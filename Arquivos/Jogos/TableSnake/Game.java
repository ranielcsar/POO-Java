package tableSnake;

import java.awt.*;
import java.util.Random;

public class Game {

    private Elemento comida;
    private Elemento comidaResultado;
    private final Snake cobra;
    private final Matematica math;
    private int score = 0;
    public int contadora = 0;
    private int numeroRandom;
    private int numero;
    private int resultado;
    
    private int x, y;
    private int cantos;
    
    private boolean hasNumber;
    private boolean aumentarRandom;
    private boolean acertou;
    private boolean desenhar;
    private boolean checandoResultado;
    
    private Direction movimento = Direction.BAIXO;
    private Direction lastMove = movimento;

    Game()
    {        
        this.cobra = new Snake();
        this.math = new Matematica();
        novaComida();
        atualizar();
    }

    void atualizar() 
    { 
    	moverCobra();
    }

    void novaComida()
    {        
        Random rX = new Random();
        Random rY = new Random();
        Random random = new Random();
        
        numeroRandom = random.nextInt(10);
        
        if (aumentarRandom)
        {
            numeroRandom = random.nextInt(math.multiplicar());
            
            comidaResultado = new Elemento(Elemento.Tipo.COMIDA,
                    rX.nextInt(Propriedades.COL), rY.nextInt(Propriedades.ROW), math.multiplicar());
        } else {
           comidaResultado = null;
        }
        
        comida = new Elemento(Elemento.Tipo.COMIDA,
    	        rX.nextInt(Propriedades.COL), rY.nextInt(Propriedades.ROW), numeroRandom);
        
        
        if (cobra.contains(comida) || cobra.contains(comidaResultado))
        {         	
            novaComida();                       
        }
    }
    
    public Elemento getComida()
    { 
    	return comida;
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
        if (comeu() && !checandoResultado)
        {
            numero = comida.getNumero();
            
            desenhar = false;
            
            math.adicionarNumeros(numero);
            
            contadora++;
            
            if (contadora == 2)
            {
            	aumentarRandom = true;                               
                checandoResultado = true;
                
            	novaComida();
            } else {
            	aumentarRandom = false;              
            	
            	novaComida();
            }
        }
        
        if (comeuResultado() || comeu())
        {
            checarResultado();
            novaComida();
        } 
    }
    
    private void checarResultado()
    {
    	if (comeuResultado())
    	{
            aumentarCobra();
            acertou = true;
    	} else {
            diminuirCobra();
            acertou = false;
    	}
        
        desenhar = true;
        checandoResultado = false;
        aumentarRandom = false;
        contadora = 0;
    }
    
    private void sair()
    {
       System.out.println("Pontuação final: " + getScore());
       System.exit(0);
    }

    int getScore()
    {
    	return score;
    }

    public boolean comeu()
    { 
    	return cobra.getHead().igual(comida);
    }
    
    public boolean comeuResultado()
    { 
    	return cobra.getHead().igual(comidaResultado);
    }

    private void aumentarCobra()
    {         
       cobra.crescer();
       score += 5;
    }
    
    private void diminuirCobra()
    {
    	cobra.diminuir();
    	score -= 5;
        
        if (cobra.getSize() < 1)
        {
           sair();
        }
    }
     
    void pintar(Graphics g)
    {         
        Graphics2D lapis = (Graphics2D) g;

        lapis.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        lapis.setFont(new Font("Verdana", 1, 20));

        pintarCobra(lapis); 
        pintarComida(lapis);
        math.desenhaPainel(lapis);
        
        if (desenhar)
        {
           desenhaResultado(lapis, acertou); 
        } else {
           lapis.drawString("?", 710, 67);
        }
        
        score(lapis);
    }
    
    public void desenhaResultado(Graphics2D lapis, boolean acertou)
    {       
        if (acertou)
        {
            lapis.setColor(Propriedades.SNAKE);
            lapis.drawString(Integer.toString(math.multiplicar()), 710, 67);		
        } else {		
            lapis.setColor(Propriedades.FOOD);
            lapis.drawString(Integer.toString(math.multiplicar()), 710, 67);
        }
    }
     
     void pintarCobra(Graphics2D lapis)
     {         
         cantos = Propriedades.PIXELS / 3;

         for (Elemento element : cobra)
         {
             x = element.getX() * Propriedades.PIXELS;
             y = element.getY() * Propriedades.PIXELS;

             int xHead = cobra.getHead().getX() * Propriedades.PIXELS;
             int yHead = cobra.getHead().getY() * Propriedades.PIXELS;

             lapis.setColor(Propriedades.HEAD);
                lapis.fillRoundRect(xHead + 1, yHead + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);

             lapis.setColor(Propriedades.SNAKE);
                lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);                        
          }
      }
     
      
    void pintarComida(Graphics2D lapis)
    {
        x = comida.getX() * Propriedades.PIXELS;
        y = comida.getY() * Propriedades.PIXELS;
        cantos = Propriedades.PIXELS / 3;

        lapis.setFont(new Font("Verdana", 1, 20));

        if (!aumentarRandom)
        {
           lapis.setColor(Propriedades.FOOD);      
              lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);         

           lapis.setColor(Color.WHITE);
              lapis.drawString(Integer.toString(comida.getNumero()), x + 8, y + 23);		     

        } else if (aumentarRandom) {             
             lapis.setColor(Propriedades.FOOD);      
                 lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);         

                    lapis.setColor(Color.WHITE);

                    if (comida.getNumero() < 10)
                    {
                       lapis.drawString(Integer.toString(comida.getNumero()), x + 8, y + 23);
                    } else {
                       lapis.drawString(Integer.toString(comida.getNumero()), x + 1, y + 23);
                    }

             pintarComidaResultado(lapis);		     

         } else {
             aumentarRandom = false;
         }	    
     }

    void pintarComidaResultado(Graphics2D lapis)
    {
        x = comidaResultado.getX() * Propriedades.PIXELS;
        y = comidaResultado.getY() * Propriedades.PIXELS;
        int cantos = Propriedades.PIXELS / 3;

        resultado = comidaResultado.getNumero();

        lapis.setColor(Propriedades.FOOD); 	     
           lapis.fillRoundRect(x + 1, y + 1, Propriedades.PIXELS - 2, Propriedades.PIXELS - 2, cantos, cantos);

        lapis.setColor(Color.WHITE);
        if (resultado < 10)
        {
            lapis.drawString(Integer.toString(resultado), x + 8, y + 22);
        } else {
            lapis.drawString(Integer.toString(resultado), x + 1, y + 22);
        }
    }
     
    void score(Graphics2D lapis)
    {
        lapis.setColor(Color.decode("#efd19f"));
        lapis.setFont(new Font("Verdana", 1, 25));
        lapis.drawString("Pontuação: " + getScore(), 20, 40);
    }
}
