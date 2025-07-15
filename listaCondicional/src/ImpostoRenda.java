import java.util.*;

public class ImpostoRenda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salario, imposto;

        System.out.print("Digite o seu salário mensal: R$");
        salario = sc.nextDouble();

        imposto = 0.0;

        if (salario <= 2112.00) {
            System.out.println("Isento de imposto de renda.");
        } else if (salario <= 2826.65) {
            imposto = salario * 0.075;
        } else if (salario <= 3751.05) {
            imposto = salario * 0.15;
        } else if (salario <= 4664.68) {
            imposto = salario * 0.225;
        } else {
            imposto = salario * 0.275;
        }

        if (salario > 2112.00) {
            System.out.printf("O valor do imposto de renda a ser pago é: R$%.2f%n", imposto);
        }

        sc.close();
    }
}
