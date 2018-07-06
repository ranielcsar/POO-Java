package FabricaCarros;

public class testDrive {
   public static void main(String []args)
   {
      Carro meuCarro = new Carro();
      
      meuCarro.cor = "preto";
      meuCarro.modelo = "Mustang GT";
      meuCarro.velocidadeAtual = 0;
      meuCarro.velocidadeMaxima = 100;
      
      meuCarro.liga();
      
      meuCarro.acelera(100);
      
      System.out.println("Velocidade do carro: " + meuCarro.velocidadeAtual);
   }
}
