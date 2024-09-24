import java.util.*;

public class media {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); 
        
        System.out.print("Digite o número de casos de teste (N): ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            
            System.out.print("Digite os três valores reais (com uma casa decimal): ");
            double valor1 = sc.nextDouble();
            double valor2 = sc.nextDouble();
            double valor3 = sc.nextDouble();

            double peso1 = 2.0;
            double peso2 = 3.0;
            double peso3 = 5.0;
            double somaPesos = peso1 + peso2 + peso3;

            double mediaPonderada = (valor1 * peso1 + valor2 * peso2 + valor3 * peso3) / somaPesos;

            System.out.printf("Média Ponderada: %.1f%n", mediaPonderada);
        }

        sc.close();
  }
  }