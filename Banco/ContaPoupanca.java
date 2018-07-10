public class ContaPoupanca extends Conta {
   final double taxaRendimento = 2.0000005;

   public ContaPoupanca(int conta, String agencia, String titular, String senha, double saldo)
   {
      super(conta, agencia, titular, senha, saldo);
   }
   
   public String rendimento()
   {
      setSaldo(getSaldo() * this.taxaRendimento);
      
      return "Crédito atribuido à conta! Seu novo saldo é de: R$ " + getSaldo();
   }
   
}
