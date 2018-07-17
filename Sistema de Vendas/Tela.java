public class Tela {
    public static void main(String []args)
    {
        Vendedor[] vendedores = new Vendedor[2];
            vendedores[0] = new Vendedor(0, "Voldemort", "Senhor do Bonfim - BA");
            vendedores[1] = new Vendedor(1, "Dumbledore", "Senhor do Bonfim - BA");
            
        Cliente[] clientes = new Cliente[2];
            clientes[0] = vendedores[0].cadastrarCliente(0, "Raniel César", "Senhor do Bonfim - BA");
            clientes[1] = vendedores[1].cadastrarCliente(1, "Ranoob César", "Senhor do Bonfim - BA");
            
        Produto[] produtos = new Produto[20];
           produtos[0] = vendedores[0].cadastrarProduto(0, 15, 3.70, "Unidade", "Feijão");
           produtos[1] = vendedores[0].cadastrarProduto(5, 20, 2.85, "Unidade", "Arroz");
           produtos[2] = vendedores[0].cadastrarProduto(2, 8, 25, "kg", "Carne de Sol");
           produtos[3] = vendedores[0].cadastrarProduto(3, 8, 0.90, "Unidade", "Sal");
           produtos[4] = vendedores[0].cadastrarProduto(4, 8, 10, "kg", "Frango");
            
        Venda[] vendas = new Venda[5];
            vendas[0] = vendedores[0].vender(0, "Em andamento.", "16/07/2018", clientes[0], vendedores[0], "Cartão de Crédito");
                ItensVenda[] item = new ItensVenda[5];
                    
                item[0] = vendedores[0].incluirVenda(0, produtos[0], 2, vendas[0]);
                item[0] = vendedores[0].incluirVenda(1, produtos[1], 4, vendas[0]);
                item[0] = vendedores[0].incluirVenda(2, produtos[3], 5, vendas[0]);
            vendedores[0].fecharVenda(vendas[0]);
    }    
}
