import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListaAluno {
    public static void main(String []args)
    {
        List<Aluno> lista = new ArrayList<Aluno>();
        
        ComparaAluno comparar = new ComparaAluno();
        Aluno aluno;
        
        // adiciona elementos à lista instanciada na linha 10
        Aluno vader = new Aluno("Darth Vader", "Lado Negro", 0);
        Aluno majinboo = new Aluno("Majin Boo", "Transformando em doces", 0);
        Aluno doflamingo = new Aluno("Donquixote Doflamingo", "Como roubar o trono", 0);
        
        lista.add(vader);
        lista.add(majinboo);
        lista.add(doflamingo);        
      
        Collections.sort(lista, comparar); // ordena e compara pra ver se são iguais        
        
        Iterator<Aluno> itr = lista.iterator(); // usado para percorrer a lista
        
        while (itr.hasNext())
        {
        	aluno = itr.next();
        	System.out.println("Nome: " + aluno.getNome());
        	System.out.println("Curso: " + aluno.getCurso());
        	System.out.println("Nota: " + aluno.getNota());
        	System.out.println("------------------------------- \n");
        }
    }
}
