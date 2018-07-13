public class Vendedor {
   private int codigo;
   private String nome;
   private String endereco;

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

   public String getEndereco() { return endereco; }

   public void setEndereco(String endereco) { this.endereco = endereco; }
   
   public Venda vender(int codigo, String situacao, String data, Cliente cliente, Vendedor vendedor, String formaPagamento)
   {
      return new Venda(codigo, situacao, data, cliente, vendedor, formaPagamento);
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
      return new Cliente(codigo, nome, endereco);
   }
   
   public ItensVenda incluirVenda(int codigo, Produto produto, int quantidade, Venda venda)
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
   
   public ItensVenda incluirVenda(int codigo, Produto produto, int quantidade, double descontoPorcentagem, Venda venda)
   {
      double valorUnidade = produto.getValorUnidade();
      double subTotal = valorUnidade * quantidade;
      
      subTotal = subTotal - ((subTotal * descontoPorcentagem) / 100);
      
      ItensVenda item = new ItensVenda();
      
      item.setCodigoItem(codigo);
      item.setProduto(produto);
      item.setQuantidadeItens(quantidade);
      item.setSubtotal(subTotal);
      item.setVenda(venda);
      
      return item;
   }
   
   public String fecharVenda(Venda venda)
   {
        venda.setSituacao("Finalizado");
        return "Venda finalizada!";        
    }
}