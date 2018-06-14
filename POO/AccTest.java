import java.util.Scanner;

public class AccTest {
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      double valorDeposito;
      
      Account conta1 = new Account("Raniel", 75.53);
      Account conta2 = new Account("Noob", -5.25);
      
      System.out.println("Saldo inicial em: " + conta1.getName() + "\nR$ " + conta1.getBalance());
      System.out.println("Saldo inicial em: " + conta2.getName() + "\nR$ " + conta2.getBalance() + "\n");
      
      System.out.print("Entre com o valor do depósito para a conta " + conta1.getName() + ": ");
      valorDeposito = scan.nextDouble();
      conta1.deposito(valorDeposito);      
      System.out.println("Valor depositado com sucesso!");
      
      System.out.print("Entre com o valor do depósito para a conta " + conta2.getName() + ": ");
      valorDeposito = scan.nextDouble();
      conta2.deposito(valorDeposito);      
      System.out.println("Valor depositado com sucesso! \n");
      
      System.out.println("Saldo em contas > ");
      conta1.showStatus();
      conta2.showStatus();
   }
}
