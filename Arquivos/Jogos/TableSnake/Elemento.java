package cobrinha;

public class Elemento {
    
    private Tipo tipo;
    private int x, y;
    
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
    
    
    void setTipo(Tipo tipo) { this.tipo = tipo; }   
    
    Tipo getTipo() { return tipo; }
    
    int getX() { return x; }
    
    int getY() { return y; }
    
    
    public boolean igual(Object objeto) 
    {        
        if (!(objeto instanceof Elemento)) { return false; }
        
        Elemento elemento = (Elemento) objeto;
        
        return elemento.x == x && elemento.y == y;
    }

    public String toString ()
    {
        return tipo + " em: (" + x + ", " + y + ")";
    }
    
    
    enum Tipo {
        VAZIO,
        COBRA,
        COMIDA
    }
}