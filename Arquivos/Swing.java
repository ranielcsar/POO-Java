
import javax.swing.JOptionPane;

public class Swing {
    public static void main(String[] args)
    {        
        // - Leitura de String        
                            
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        String sobreNome = JOptionPane.showInputDialog("Digite seu sobrenome: ");
        
        String nomeCompleto = nome + " " + sobreNome;
        
        JOptionPane.showMessageDialog(null, "Nome completo: " + nomeCompleto, "STRING", JOptionPane.INFORMATION_MESSAGE);
        
        
        // - Leitura de inteiros (int)        
        
        int valorA = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro valor: "));
        int valorB = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo valor: "));
        
        int resultado = valorA * valorB;
        
        JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "INTEIROS", JOptionPane.INFORMATION_MESSAGE);
        
        
        // - Leitura de decimais (floats)
        
        float primeiraNota = Float.parseFloat(JOptionPane.showInputDialog("Digite a primeira nota: "));
        float segundaNota = Float.parseFloat(JOptionPane.showInputDialog("Digite a segunda nota: "));
        
        float media = (primeiraNota + segundaNota) / 2;
        
        JOptionPane.showMessageDialog(null, "Média final: " + media, "FLOATS", JOptionPane.INFORMATION_MESSAGE);
    }
}
