public class Account {
   private String name;
   private double balance;
   
   public Account(String nome, double saldo)
   {
      this.name = nome;
      
      if (saldo > 0.0) { this.balance = saldo; }
   }
   
   public void deposito(double quantia)
   { 
      if (quantia > 0.0) { balance += quantia; }
   }
   
   public void showStatus()
   {
      System.out.println("Saldo disponível na conta do Sr(a). " + this.name + ": R$ " + this.balance);
   }
   
   public double getBalance() { return balance; }
   
   public void setName(String nome) { this.name = nome; }
   
   public String getName() { return name; }   
}
