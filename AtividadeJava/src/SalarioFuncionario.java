import java.util.Scanner;

public class SalarioFuncionario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número do funcionário: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o número de horas trabalhadas: ");
        int horas = scanner.nextInt();
        System.out.print("Digite o valor que recebe por hora: ");
        double valorPorHora = scanner.nextDouble();
        
        double salario = horas * valorPorHora;
        
        System.out.printf("Número do Funcionário: %d\nSalário: %.2f\n", numero, salario);
        
        scanner.close();
    }
}