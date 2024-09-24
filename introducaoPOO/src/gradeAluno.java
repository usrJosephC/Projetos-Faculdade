import java.util.*;

class Student {
  // Atributos
  private String name;
  private double grade1; // Nota do primeiro trimestre
  private double grade2; // Nota do segundo trimestre
  private double grade3; // Nota do terceiro trimestre

  // Construtor
  public Student(String name, double grade1, double grade2, double grade3) {
      this.name = name;
      this.grade1 = grade1;
      this.grade2 = grade2;
      this.grade3 = grade3;
  }

  // Método para calcular a nota final
  public double finalGrade() {
      return grade1 + grade2 + grade3;
  }

  // Método para verificar se o aluno está aprovado
  public String checkApproval() {
      double finalGrade = finalGrade();
      if (finalGrade >= 60) {
          return "PASS";
      } else {
          double pointsNeeded = 60 - finalGrade;
          return "FAILED. Faltam " + pointsNeeded + " pontos para aprovação.";
      }
  }

  // Método para obter o nome do aluno
  public String getName() {
      return name;
  }
}

public class gradeAluno {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    // Leitura dos dados do aluno
    System.out.print("Digite o nome do aluno: ");
    String name = scanner.nextLine();

    System.out.print("Digite a nota do primeiro trimestre: ");
    double grade1 = scanner.nextDouble();

    System.out.print("Digite a nota do segundo trimestre: ");
    double grade2 = scanner.nextDouble();

    System.out.print("Digite a nota do terceiro trimestre: ");
    double grade3 = scanner.nextDouble();

    // Criação do objeto Student
    Student student = new Student(name, grade1, grade2, grade3);

    // Cálculo da nota final e verificação de aprovação
    double finalGrade = student.finalGrade();
    String approvalStatus = student.checkApproval();

    // Exibição dos resultados
    System.out.printf("Nome do aluno: %s%n", student.getName());
    System.out.printf("Nota final: %.2f%n", finalGrade);
    System.out.println(approvalStatus);

    scanner.close();
    }
  }
 
