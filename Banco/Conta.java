public class Conta {
    private int conta;
    private double saldo;
    private String agencia;
    private String titular;
    private String senha;
    
    public Conta(int conta, String agencia, String titular, String senha, double saldo)
    {
        this.conta = conta;
        this.agencia = agencia;
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    }

    public int getConta() { return conta; }

    public String getAgencia() { return agencia; }

    public String getTitular() { return titular; }

    public String getSenha() { return senha; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public void setTitular(String titular) { this.titular = titular; }

    public void setSenha(String senha) { this.senha = senha; }
    
    public double getSaldo() { return this.saldo; }
    
    public String sacar(double saque)
    {
        if (this.saldo >= saque)
        {
            saldo -= saque;
            return "Saque efetuado com sucesso! Seu saldo atual é" + this.saldo;
        } else {
            return "Saldo indisponível.";
        }
    }
    
    public String depositar(double deposito)
    {
        if (deposito > 0)
        {
            saldo += deposito;
            return "Deposito efetuado com sucesso! Seu novo saldo é: " + this.saldo;
        } else {
            return "Valor incorreto.";
        }
    }
    
    public String transferir(double transferencia)
    {
        if (transferencia <= this.saldo && transferencia > 0)
        {
            this.saldo -= transferencia;
            return "Movimentação realizada com sucesso! Seu novo saldo é: " + this.saldo;
        } else {
            return "Saldo indisponível.";
        }
    }
}