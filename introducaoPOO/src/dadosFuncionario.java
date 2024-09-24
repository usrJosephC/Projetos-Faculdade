import java.util.*;

class Employee {
  // Atributos
  private String name;
  private double grossSalary;
  private double tax;

  // Construtor
  public Employee(String name, double grossSalary, double tax) {
      this.name = name;
      this.grossSalary = grossSalary;
      this.tax = tax;
  }

  // Método para calcular o salário líquido
  public double NetSalary() {
      return grossSalary - tax;
  }

  // Método para aumentar o salário bruto
  public void IncreaseSalary(double percentage) {
      grossSalary += grossSalary * (percentage / 100);
  }

  // Métodos getters
  public String getName() {
      return name;
  }

  public double getGrossSalary() {
      return grossSalary;
  }
}


public class dadosFuncionario {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do funcionário
        System.out.print("Digite o nome do funcionário: ");
        String name = scanner.nextLine();
        
        System.out.print("Digite o salário bruto do funcionário: $ ");
        double grossSalary = scanner.nextDouble();
        
        System.out.print("Digite o imposto do funcionário: $ ");
        double tax = scanner.nextDouble();

        // Criação do objeto Employee
        Employee employee = new Employee(name, grossSalary, tax);

        // Exibição dos dados do funcionário
        System.out.printf("Funcionário: %s%n", employee.getName());
        System.out.printf("Salário líquido: $ %.2f%n", employee.NetSalary());

        // Aumento do salário
        System.out.print("Digite a porcentagem de aumento: ");
        double percentage = scanner.nextDouble();
        
        employee.IncreaseSalary(percentage);

        // Exibição dos dados atualizados do funcionário
        System.out.printf("Dados atualizados:%n");
        System.out.printf("Funcionário: %s%n", employee.getName());
        System.out.printf("Salário líquido após aumento: $ %.2f%n", employee.NetSalary());

        scanner.close();
  }
}
