import java.util.Comparator;

public class ComparaAluno implements Comparator<Aluno> {
    public int compare(Aluno primeiro, Aluno segundo)
    {
        return primeiro.getNome().compareTo(segundo.getNome());
    }
}