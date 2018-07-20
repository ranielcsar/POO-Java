package Sistema_deVendas;

public class Calculos {
   private double subtotal;
   private double faturamento;
   
   void setValorTotal(double valor) { this.subtotal += valor; } 
   
   void setFaturamentoTotal(ItensVenda[] itens)
   {
      for (ItensVenda item : itens)
      {
         this.faturamento += item.getSubtotal();
      }
   }
   
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
}