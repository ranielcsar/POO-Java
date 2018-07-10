public class Tela {
   public static void main(String []args)
   {
      ContaCorrente corrente = new ContaCorrente(4558, "455-X", "Ranoob", "123456", 55.55);
      
      System.out.println("------ CONTA CORRENTE ------");
      System.out.println(corrente.depositar(150));
      System.out.println(corrente.transferir(50));
      System.out.println(corrente.sacar(35.55) + "\n");
      System.out.println("____________________________________________ \n");
      
      ContaPoupanca poupanca = new ContaPoupanca(4558, "455-X", "Ranoob", "123456", 30);
      
      System.out.println("------ CONTA POUPANÇA ------");
      System.out.println(poupanca.depositar(150));
      System.out.println(poupanca.rendimento());
   }
}
