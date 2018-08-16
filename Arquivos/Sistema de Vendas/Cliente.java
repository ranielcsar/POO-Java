package Sistema_deVendas;

public class Cliente {
   private int codigoAcesso;
   private String nome;
   private String endereco;

   public Cliente(int codigoAcesso, String nome, String endereco)
   {
       this.codigoAcesso = codigoAcesso;
       this.nome = nome;
       this.endereco = endereco;
   }

   public int getCodigoAcesso() { return codigoAcesso; }   

   public String getNome() { return nome; }    

   public String getEndereco() { return endereco; }     
}