package Sistema_deVendas;

public class Calculos {
   private double subtotal;
   private double faturamento;
   
   void setValorTotal(double valor) { this.subtotal += valor; }   
   
   public double getFaturamentoTotal() { return faturamento; }
   
   double faturamentoData(Venda venda, ItensVenda[] itens)
   {  
      double total = 0;
      
      String data = venda.getDataVenda();
      
      for (ItensVenda item : itens)
      {
         if (item != null)
         {
            if (data == item.getVenda().getDataVenda())
            {
               total += item.getSubtotal();
            }
         }         
      }     
     
      return total;
   }
   
   public void mostrarFaturamentos(Venda[] vendas, ItensVenda[] itens)
   {
      System.out.println("---------- FATURAMENTOS ----------");
      
      for (Venda venda : vendas)
      {
         if (venda != null)
         {
            System.out.println("Faturamento da data " + venda.getDataVenda() + ": R$ " + this.faturamentoData(venda, itens) + ".");
            faturamento += this.faturamentoData(venda, itens);
         }
      }      
      System.out.println("Faturamento TOTAL: R$ " + this.getFaturamentoTotal());
      System.out.println("--------------------------------------");      
   }
}