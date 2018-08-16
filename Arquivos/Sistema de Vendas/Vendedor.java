package Sistema_deVendas;

public class Vendedor {  
   private int codigo;
   private String nome;
   private String endereco;
   public Calculos calculo = new Calculos();

   public Vendedor(int codigo, String nome, String endereco)
   {
      this.codigo = codigo;
      this.nome = nome;
      this.endereco = endereco;      
   }

   public int getcodigo() { return codigo; }

   public void setcodigo(int codigo) { this.codigo = codigo; }

   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; } 
   
   public Venda vender(int codigo, String data, Cliente cliente, Vendedor vendedor, String formaPagamento, String situacao)
   {
      return new Venda(codigo, data, cliente, vendedor, formaPagamento, situacao);
   }
   
   public String cancelarVenda(Venda venda)
   {
      venda.setSituacao("Cancelado!");
      return "Venda cancelada!";
   }
   
   public String cancelarItem() { return null; }
   
   public Produto cadastrarProduto(int codigo, int quantidade, double preco, String tipo, String nome)
   {
      return new Produto(codigo, quantidade, preco, tipo, nome);
   }
   
   public Cliente cadastrarCliente(int codigo, String nome, String endereco)
   {
      System.out.println("Cliente cadastrado!");
      return new Cliente(codigo, nome, endereco);      
   }
   
   public ItensVenda incluirItem(int codigo, Produto produto, int quantidade, Venda venda)
   {
      double valorUnidade = produto.getValorUnidade();
      double subTotal = valorUnidade * quantidade;
      
      ItensVenda item = new ItensVenda();
      
      item.setCodigoItem(codigo);
      item.setProduto(produto);
      item.setQuantidadeItens(quantidade);
      item.setSubtotal(subTotal);
      item.setVenda(venda);
      
      return item;
   }
   
   public ItensVenda incluirItem(int codigo, Produto produto, int quantidade, int descontoPorcentagem, Venda venda)
   {
      double valorUnidade = produto.getValorUnidade();
      double subTotal = valorUnidade * quantidade;
      
      subTotal = subTotal - ((subTotal * descontoPorcentagem) / 100);
      
      ItensVenda item = new ItensVenda();
      
      item.setCodigoItem(codigo);
      item.setProduto(produto);
      item.setQuantidadeItens(quantidade);
      item.setDesconto(descontoPorcentagem);
      item.setSubtotal(subTotal);
      item.setVenda(venda);
      
      return item;
   }
   
   public void mostrarVenda(ItensVenda[] itens, Venda venda)
   {
      Cliente cliente = venda.getCliente();
      Vendedor vendedor = venda.getVendedor();     
      
      System.out.println("---------- VENDA ----------");
      System.out.println("Código da venda: "+ venda.getCodigoVenda() + "\nSituação: " + venda.getSituacao() + "\nData da venda: " + venda.getDataVenda() +
                "\nNome do Cliente: " + cliente.getNome() + "\nVendedor: " + vendedor.getNome() + "\nForma de pagamento: " + 
                venda.getFormaPagamento());
      System.out.println("-------------------------------------- \n");
      
      System.out.println("ITENS DA VENDA: \n");
      
      double valorTotal = 0;
      
      for (ItensVenda item : itens)
      {  
         if (item != null)
         {
            if (item.getVenda() == venda)
            {
               System.out.println("Código do item: " + item.getCodigoItem() + "; Desconto: " + item.getDesconto() +
                    "%; Nome do produto: " + item.getProduto().getNome() + "; Quantidade: " + item.getQuantidadeItens() +
                    "; Subtotal: R$ "+ item.getSubtotal() + "\n");
               
               valorTotal += item.getSubtotal();
            }
         }         
      }
      
      System.out.println("--------------------------------------");
      System.out.println("Valor total da venda: R$ " + valorTotal);
      System.out.println("-------------------------------------- \n");
   } 
   
   public String fecharVenda(Venda venda)
   {
        venda.setSituacao("Finalizado");
        return "Venda finalizada!";        
    }
}