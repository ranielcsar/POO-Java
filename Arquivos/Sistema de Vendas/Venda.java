package Sistema_deVendas;

public class Venda {
    private int codigoVenda;
    private String situacao;
    private String dataVenda;
    private Cliente cliente;
    private Vendedor vendedor;
    private String formaPagamento;

    public Venda(int codigoVenda, String dataVenda, Cliente cliente, Vendedor vendedor, String formaPagamento, String situacao)
    {
        this.codigoVenda = codigoVenda;
        this.situacao = situacao;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.formaPagamento = formaPagamento;
    }

    public int getCodigoVenda() { return codigoVenda; }

    public void setCodigoVenda(int codigoVenda) { this.codigoVenda = codigoVenda; }

    public String getSituacao() { return situacao; }

    public void setSituacao(String situacao) { this.situacao = situacao; }
    
    public String getDataVenda() { return dataVenda; }

    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Vendedor getVendedor() { return vendedor; }

    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }

    public String getFormaPagamento() { return formaPagamento; }

    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}
