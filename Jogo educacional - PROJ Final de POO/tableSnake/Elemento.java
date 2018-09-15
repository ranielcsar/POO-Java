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

public class Elemento {
    
    private Tipo tipo;
    private int numero;
    private int x, y;
    
    public Elemento() { }
    
    public Elemento(int x, int y)
    {
        this(Tipo.VAZIO, x, y);
    }
    
    
    public Elemento(Tipo tipo, int x, int y)
    {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }
    
    public Elemento(Tipo tipo, int x, int y, int numero)
    {
    	this.tipo = tipo;
    	this.numero = numero;
        this.x = x;
        this.y = y;
    }  
    
    Tipo getTipo() { return tipo; }    
    int getX() { return x; }    
    int getY() { return y; }    
    int getNumero() { return this.numero; }
    
    void setX(int x) { this.x = x; }
    void setY(int y) { this.y = y; }
    
    
    public boolean igual(Object objeto) 
    {        
        if (!(objeto instanceof Elemento)) { return false; }
        
        Elemento elemento = (Elemento) objeto;      
        
        return elemento.x == x && elemento.y == y;
    }
    
    enum Tipo {
        VAZIO,
        COBRA,
        COMIDA
    }
}