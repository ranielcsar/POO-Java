import java.util.HashSet;
import java.util.Set;

public class ListaAlunoSet {
    public static void main(String []args)
    {
        Set<Aluno> conjunto = new HashSet<Aluno>();
        
        Aluno vader = new Aluno("Darth Vader", "Lado Negro", 0);
        Aluno majinboo = new Aluno("Majin Boo", "Transformando em doces", 0);
        Aluno doflamingo = new Aluno("Donquixote Doflamingo", "Como roubar o trono", 0);
        
        conjunto.add(vader);
        conjunto.add(majinboo);
        conjunto.add(doflamingo);
        
        System.out.println(conjunto);
    }
}
