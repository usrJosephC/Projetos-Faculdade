import java.util.Scanner;

public class Diferenca {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor de A: ");
        int A = scanner.nextInt();
        System.out.print("Digite o valor de B: ");
        int B = scanner.nextInt();
        System.out.print("Digite o valor de C: ");
        int C = scanner.nextInt();
        System.out.print("Digite o valor de D: ");
        int D = scanner.nextInt();
        
        int diferenca = (A * B) - (C * D);
        
        System.out.println("A diferença é: " + diferenca);
        
        scanner.close();
    }
}