package Collections;

import java.util.ArrayList;
import java.util.Collection;

public class Exemplo1 {
   public static void main(String []args)
   {
      Collection<String> nomes = new ArrayList();
         nomes.add("Raniel");
         nomes.add("Noob");
         nomes.add("Maria");
         nomes.add("Jeff");
         nomes.add("Poo");
         nomes.add("Ness");
         
      for (String nome : nomes)
      {
         System.out.println(nome);
      }
      
      nomes.remove("Raniel");
      
      System.out.println("Lista atualizada: " + nomes);
      
      nomes.clear();
      
      System.out.println("Lista atualizada: " + nomes);
   }
}
