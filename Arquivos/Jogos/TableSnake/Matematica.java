package tableSnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Matematica {
	
    private int numero1, numero2;
    private boolean hasNumber = false;
    boolean temResultado = false;

    public Matematica() { }

    public int multiplicar()
    {
        return numero1 * numero2;
    }

    public int dividir()
    {
        return numero1 / numero2;
    }

    public void adicionarNumeros(int numero)
    {
        if (!hasNumber)
        {
            setNumero1(numero);
            hasNumber = true;    		
        } else {
            setNumero2(numero);
            hasNumber = false;
            
            temResultado = true;
        }
    }

    public void desenhaPainel(Graphics2D lapis)
    {    	 
        lapis.setColor(Color.white);
        lapis.drawRoundRect(480, 20, 300, 60, 20, 20);
        lapis.setFont(new Font("Verdana", 1, 45)); 		

        lapis.drawString(Integer.toString(getNumero1()), 490, 67);
        lapis.drawString("x", 550, 65); 	 		
        lapis.drawString(Integer.toString(getNumero2()), 610, 67);
        lapis.drawString("=", 660, 67);
    }
    
    public void desenhaResultado(Graphics2D lapis, boolean acertou)
    {
        if (!temResultado)
        {
            lapis.drawString("?", 710, 67);
        }
        
        if (temResultado && acertou)
        {
            lapis.setColor(Propriedades.SNAKE);
            lapis.drawString(Integer.toString(multiplicar()), 710, 67);
		
        } else if (temResultado && !acertou) {
		
            lapis.setColor(Propriedades.FOOD);
            lapis.drawString(Integer.toString(multiplicar()), 710, 67);
        }
    }

    public void reset()
    {
       setNumero1(0);
       setNumero2(0);         
    }

    public void setNumero1(int numero1) { this.numero1 = numero1; }
    public void setNumero2(int numero2) { this.numero2 = numero2; }

    public int getNumero1() { return numero1; }
    public int getNumero2() { return numero2; }

}
