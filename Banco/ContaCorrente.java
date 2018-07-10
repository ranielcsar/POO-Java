public class ContaCorrente extends Conta {
   private int saqueMensal;
   private int extratoMensal;
   private double limite;
   private double limiteInicial;
   
   public ContaCorrente(int conta, String agencia, String titular, String senha, double saldo)
   {
      super(conta, agencia, titular, senha, saldo);
      
      this.saqueMensal = saqueMensal;
      this.extratoMensal = extratoMensal;
      this.limite = limite;
      this.limiteInicial = limite;
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
      double saldoTotal = this.limite + getSaldo();
      
      if (saldoTotal >= valorSaque)
      {
         double limiteAnterior;
         double restante = getSaldo() - valorSaque;
         
         if (restante < 0)
         {
            setSaldo(0);
            limiteAnterior = this.limite - restante;
            
            this.limite += restante;
            return "Saque efetuado com sucesso! Seu saldo é de: R$ " + this.getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limite + "! Houve uma movimentação de: R$ " + (limiteAnterior - limite);
         } else {
            setSaldo(getSaldo() - valorSaque);
            
            return "Saque efetuado com sucesso! Seu saldo é de: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limite;
         }
      } else {
         return "Saldo indisponível!";
      }
   }
   
   public String depositar(double valorDeposito)
   {
      if (limiteInicial > limite)
      {
         double restante = this.limiteInicial - this.limite;
         
         if (valorDeposito > restante)
         {
            this.limite = limiteInicial;
            setSaldo(valorDeposito - restante);
            
            return "Depósito efetudado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limite;
         } else {
            this.limite += valorDeposito;
            
            return "Depósito efetuado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limite;
         }
      } else {
         setSaldo(getSaldo() + valorDeposito);
         return "Depósito efetuado com sucesso! Seu novo saldo é: R$ " + getSaldo() + ". "
                    + "Seu limite é de: R$ " + this.limite;
      }
   }   
}