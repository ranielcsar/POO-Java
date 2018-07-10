public class ContaCorrente extends Conta {
   private int saqueMensal;
   private int extratoMensal;   
   private double limiteInicial;
   private double limiteAtual;
   
   public ContaCorrente(int conta, String agencia, String titular, String senha, double saldo)
   {
      super(conta, agencia, titular, senha, saldo);
      
      this.saqueMensal = saqueMensal;
      this.extratoMensal = extratoMensal;
      this.limiteAtual = limiteAtual;
      this.limiteInicial = limiteAtual;
   }
   
   public void debitoCesta(double valorDebito)
   {
      if (valorDebito < getSaldo())
      {
         setSaldo(getSaldo() - valorDebito);
      } else {
         System.out.println("Saldo indisponível!");
      }
   }
   
   public String sacar(double valorSaque)
   {
      double saldoTotal = this.limiteAtual + getSaldo();
      
      if (saldoTotal >= valorSaque)
      {
         double limiteAnterior;
         double restante = getSaldo() - valorSaque;
         
         if (restante < 0)
         {
            setSaldo(0);
            limiteAnterior = this.limiteAtual - restante;
            
            this.limiteAtual += restante;
            return "Saque efetuado com sucesso! Seu saldo é de: R$ " + this.getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limiteAtual + "! Houve uma movimentação de: R$ " + (limiteAnterior - limiteAtual);
         } else {
            setSaldo(getSaldo() - valorSaque);
            
            return "Saque efetuado com sucesso! Seu saldo é de: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limiteAtual;
         }
      } else {
         return "Saldo indisponível!";
      }
   }
   
   public String depositar(double valorDeposito)
   {
      if (limiteInicial > limiteAtual)
      {
         double restante = this.limiteInicial - this.limiteAtual;
         
         if (valorDeposito > restante)
         {
            this.limiteAtual = limiteInicial;
            setSaldo(valorDeposito - restante);
            
            return "Depósito efetudado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limiteAtual;
         } else {
            this.limiteAtual += valorDeposito;
            
            return "Depósito efetuado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limiteAtual;
         }
      } else {
         setSaldo(getSaldo() + valorDeposito);
         return "Depósito efetuado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limiteAtual;
      }
   }   
}
