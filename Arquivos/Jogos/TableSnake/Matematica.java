package tableSnake;

public class Matematica {
	
	private int numero1, numero2;	
	
	public Matematica() { }
	
	public int multiplicar()
	{
		return numero1 * numero2;
	}
	
	public int dividir()
	{
		return numero1 / numero2;
	}	

	public void setNumero1(int numero1) { this.numero1 = numero1; }
	public void setNumero2(int numero2) { this.numero2 = numero2; }
	
	public int getNumero1() { return numero1; }
	public int getNumero2() { return numero2; }
	
}
