import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();

        double area = 3.14 * Math.pow(raio, 2);

        System.out.printf("A área do círculo é: %.4f\n", area);
        
        scanner.close();
    }
}