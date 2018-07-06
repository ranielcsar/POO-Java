package Banco;

public class testaFuncionario {
   public static void main(String []args)
   {
      Funcionario funcionario = new Funcionario();     
      
      funcionario.nome = "Raniel";
      funcionario.salario = 300;
      funcionario.departamento = "Tec. da Informação";
      funcionario.data.dia = 06;
      funcionario.data.mes = 07;
      funcionario.data.ano = 2018;
      funcionario.RG = "123456789";      
      
      funcionario.recebeAumento(50);
      
      funcionario.exibe();            
   }
}
