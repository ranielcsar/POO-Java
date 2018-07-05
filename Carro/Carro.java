package FabricaCarros;

public class Carro {
   String cor;
   String modelo;
   double velocidadeAtual;
   double velocidadeMaxima;
   Motor motor;
   
   void liga()
   {
      System.out.println("O carro está ligado!");
   }
   
   void acelera(double quantidade)
   {
      double velocidade = this.velocidadeAtual + quantidade;
      this.velocidadeAtual = velocidade;
   }
   
   int marcha()
   {
      if (this.velocidadeAtual < 0) { return -1; }
      
      if (this.velocidadeAtual >= 0 && this.velocidadeAtual < 40)
      {
         return 1;
      }
      
      if (this.velocidadeAtual >= 40 && this.velocidadeAtual < 80)
      {
         return 2;
      }
      
      return 3;
   }
}

class Motor {
   int potencia;
   String tipo;
}