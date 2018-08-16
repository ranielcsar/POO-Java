package Sistema_deVendas;

public class Tela {
   public static void main(String []args)
   {
      Calculos calculo = new Calculos();
      
      Vendedor[] vendedores = new Vendedor[3];
         vendedores[0] = new Vendedor(0, "Voldermot", "Sr. do Bonfim - BA");
         vendedores[1] = new Vendedor(0, "Dumbledore", "Sr. do Bonfim - BA");

      Cliente[] clientes = new Cliente[3];
         clientes[0] = vendedores[0].cadastrarCliente(0, "Harry", "Sr. do Bonfim - BA");
         clientes[1] = vendedores[0].cadastrarCliente(1, "Hermione", "Sr. do Bonfim - BA");

      System.out.println();

      Produto[] produtos = new Produto[20];
         produtos[0] = vendedores[0].cadastrarProduto(0, 15, 3.70, "Unidade", "Feijão");
         produtos[1] = vendedores[0].cadastrarProduto(5, 20, 2.85, "Unidade", "Arroz");
         produtos[2] = vendedores[0].cadastrarProduto(2, 8, 25, "kg", "Carne de Sol");
         produtos[3] = vendedores[0].cadastrarProduto(3, 8, 0.90, "Unidade", "Sal");
         produtos[4] = vendedores[0].cadastrarProduto(4, 8, 10, "kg", "Frango");

      Venda[] vendas = new Venda[5];
         vendas[0] = vendedores[0].vender(0, "19/07/2018", clientes[0], vendedores[0], "Cartão de Crédito", "Concluída.");
            ItensVenda[] itemVenda = new ItensVenda[20];
               itemVenda[0] = vendedores[0].incluirItem(0, produtos[0], 8, 10, vendas[0]);
               itemVenda[1] = vendedores[0].incluirItem(1, produtos[1], 4, vendas[0]);
               itemVenda[2] = vendedores[0].incluirItem(2, produtos[3], 3, 20, vendas[0]);
         vendedores[0].fecharVenda(vendas[0]);

         vendedores[0].mostrarVenda(itemVenda, vendas[0]);

         vendas[1] = vendedores[1].vender(1, "20/07/2018", clientes[1], vendedores[1], "Dinheiro", "Concluída");
            itemVenda[3] = vendedores[1].incluirItem(4, produtos[4], 5, vendas[1]);
            itemVenda[4] = vendedores[1].incluirItem(5, produtos[1], 3, vendas[1]);
         vendedores[0].fecharVenda(vendas[1]);         
         
         vendedores[1].mostrarVenda(itemVenda, vendas[1]);
         
         calculo.mostrarFaturamentos(vendas, itemVenda);         
   }   
}
