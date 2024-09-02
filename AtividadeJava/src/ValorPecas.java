import java.util.Scanner;

public class ValorPecas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código da peça 1: ");
        int codigo1 = scanner.nextInt();
        System.out.print("Digite o número de peças 1: ");
        int numero1 = scanner.nextInt();
        System.out.print("Digite o valor unitário da peça 1: ");
        double valor1 = scanner.nextDouble();
        
        System.out.print("Digite o código da peça 2: ");
        int codigo2 = scanner.nextInt();
        System.out.print("Digite o número de peças 2: ");
        int numero2 = scanner.nextInt();
        System.out.print("Digite o valor unitário da peça 2: ");
        double valor2 = scanner.nextDouble();

        double total = (numero1 * valor1) + (numero2 * valor2);

        System.out.printf("Valor a ser pago: %.2f\n", total);
        
        scanner.close();
    }
}