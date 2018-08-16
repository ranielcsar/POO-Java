import java.util.Scanner;

public class CPF {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        String cpf = "\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d";
        
        System.out.println("Digite seu CPF: ");
        String cpfUsuario = scan.nextLine();
        
        if (cpfUsuario.matches(cpf))
        {
            System.out.println("Valido! :D");
        } else {
            System.out.println("Invalido! D:");
        }
    }
}
