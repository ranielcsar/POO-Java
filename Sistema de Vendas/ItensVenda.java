package Sistema_deVendas;

public class ItensVenda {
    private int codigoItem;
    private int desconto;
    private Produto produto;
    private int quantidadeItens;
    private double subtotal;
    private Venda venda;

   public int getCodigoItem() { return codigoItem; }

   public void setCodigoItem(int codigoItem) { this.codigoItem = codigoItem; }
   
   public int getDesconto() { return desconto; }
   
   public void setDesconto(int desconto) { this.desconto = desconto; }
   
   public Produto getProduto() { return produto; }
   
   public void setProduto(Produto produto) { this.produto = produto; }
   
   public int getQuantidadeItens() { return quantidadeItens; }
   
   public void setQuantidadeItens(int quantidadeItens) { this.quantidadeItens = quantidadeItens; }
   
   public double getSubtotal() { return subtotal; }
   
   public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
   
   public Venda getVenda() { return venda; }
   
   public void setVenda(Venda venda) { this.venda = venda; }
}