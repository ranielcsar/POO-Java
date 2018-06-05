/* 
   Deixar normal o link que está invertido. 
   Raniel - 05 jun. 2018.
*/

import java.util.Scanner;

public class Segunda_questao {
    public static void main(String []args)
    {
        /* Scanner read = new Scanner(System.in);
        
        System.out.print("Digite o link: ");
        String link = read.nextLine();
        System.out.println(); */
        
        String link = "http://www.baixaki.com.br/?id=rb.moc.knilretrevni.www//:ptth";
        
        String[] linkCortado = link.split("=");
        
        String linkNormal = new StringBuffer(linkCortado[1]).reverse().toString();
        
        System.out.println("Link invertido: " + linkNormal);
    }
}
