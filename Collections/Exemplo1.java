package Collections;

import java.util.ArrayList;
import java.util.Collection;

public class Exemplo1 {
   public static void main(String []args)
   {
      Collection<String> nomes = new ArrayList();
         nomes.add("Raniel"); // adiciona nomes à lista 'nomes' instanciada a cima
         nomes.add("Noob");
         nomes.add("Maria");
         nomes.add("Jeff");
         nomes.add("Poo");
         nomes.add("Ness");
         
      for (String nome : nomes)
      {
         System.out.println(nome);
      }
      
      nomes.remove("Raniel"); // remove um elemento específico
      
      System.out.println("Lista atualizada: " + nomes);
      
      nomes.clear(); // passa a vassoura na lista
      
      System.out.println("Lista atualizada: " + nomes);
   }
}
