package Banco;

public class Funcionario {
   String nome;
   String departamento;
   double salario;
   Data data = new Data();
   String RG;
   
   void recebeAumento(double valorAumento) { salario += valorAumento; }
   
   double ganhoAnual() { return salario * 12; }
   
   void exibe()
   {
      System.out.println("Nome do funcionário: " + this.nome);
      System.out.println("Departamento: " + this.departamento);
      System.out.print("Contrato > ");
      System.out.print("Dia: " + this.data.dia);
      System.out.print(", Mês: " + this.data.mes);
      System.out.println(", Ano: " + this.data.ano);
      System.out.println("RG: " + this.RG);
      System.out.println("Salário atual: R$ " + this.salario);
      System.out.println("Ganho anual: R$ " + this.ganhoAnual());
   }   
}

class Data {
   int dia;
   int mes;
   int ano;
}
