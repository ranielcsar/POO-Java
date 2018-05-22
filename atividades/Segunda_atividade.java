package ranoob_atividades;

import java.util.Scanner;

public class Segunda_atividade {    
    private static Scanner entrada;

    public static void main(String []args)
    {
        int numero;
        
        entrada = new Scanner(System.in);
        
        System.out.print("Entre com um número: ");        
        numero = entrada.nextInt();
        
        String numeroString = Integer.toString(numero);
        
        for (int i = 0; i < numeroString.length(); i++)
        {
            switch (numeroString.charAt(i))
            {
                case '0':
                    System.out.println("zero ");
                    break;
                case '1':
                    System.out.println("um ");
                    break;
                case '2':
                    System.out.println("dois ");
                    break;
                case '3':
                    System.out.println("três ");
                    break;
                case '4':
                    System.out.println("quatro ");
                    break;
                case '5':
                    System.out.println("cinco ");
                    break;
                case '6':
                    System.out.println("seis ");
                    break;
                case '7':
                    System.out.println("sete ");
                    break;
                case '8':
                    System.out.println("oito ");
                    break;
                case '9':
                    System.out.println("nove ");
                    break;
                default:
                    break;
            }
        }
    }
}
