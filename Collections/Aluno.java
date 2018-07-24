public class Aluno implements Comparable<Aluno> {
    private String nome;
    private String curso;
    private double nota;

    public Aluno(String nome, String curso, double nota)
    {
        this.nome = nome;
        this.curso = curso;
        this.nota = nota;
    }
    
    public int compareTo(Aluno aluno)
    {
        return this.nome.compareTo(aluno.getNome());
    }
    
    public boolean equals(Object aluno)
    {
        Aluno auxiliar = (Aluno) aluno;
        
        return this.nome.equals(auxiliar.getNome());
    }
    
    public int hashCode() 
    {
        return this.nome.hashCode();
    }
    
    public String toString() { return this.nome; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCurso() { return curso; }

    public void setCurso(String curso) { this.curso = curso; }

    public double getNota() { return nota; }

    public void setNota(double nota) { this.nota = nota; }
}
