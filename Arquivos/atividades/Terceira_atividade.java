package ranoob_atividades;

import java.util.Scanner;

public class Terceira_atividade {
	public static void main(String[] args)
	{
		String nome;		
		int i;
		Scanner ler = new Scanner(System.in);
		
		System.out.print("Digite seu nome completo: ");
		nome = ler.nextLine();		
		
		nome = nome.replaceAll("da|das|do|dos|de|di|du", "");		
		
		/* \B - diz para não olhar o 1º char da palavra
		   \w - olhar para a palavra
		   \s* - olhar para o espaço 
		*/
		nome = nome.replaceAll("\\B\\w\\s*", "").toUpperCase();
				
		System.out.println(nome);
	}
}
