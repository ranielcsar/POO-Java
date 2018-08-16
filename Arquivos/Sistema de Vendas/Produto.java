package Sistema_deVendas;

public class Produto {
    private int codigoProduto;
    private int quantidadeProduto;
    private double valorUnidade;
    private String tipo;
    private String nome;

    public Produto(int codigoProduto, int quantidadeProduto, double valorUnidade, String tipo, String nome)
    {
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorUnidade = valorUnidade;
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getCodigoProduto() { return codigoProduto; }

    public void setCodigoProduto(int codigoProduto) { this.codigoProduto = codigoProduto; }

    public int getQuantidadeProduto() { return quantidadeProduto; }

    public void setQuantidadeProduto(int quantidadeProduto) { this.quantidadeProduto = quantidadeProduto; }

    public double getValorUnidade() { return valorUnidade; }

    public void setValorUnidade(double valorUnidade)  { this.valorUnidade = valorUnidade; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}