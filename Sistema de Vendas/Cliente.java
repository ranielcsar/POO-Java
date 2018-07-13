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

    public void setCodigoAcesso(int codigoAcesso) { this.codigoAcesso = codigoAcesso; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }    
}