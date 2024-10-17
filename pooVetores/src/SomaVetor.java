import java.util.*;

public class SomaVetor {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite a quantidade de números que deseja inserir: ");
    int N = sc.nextInt();

    double[] numeros = new double[N];

    System.out.println("Digite " + N + " números reais:");
    for (int i = 0; i < N; i++) {
      System.out.print("Número " + (i + 1) + " : ");
      numeros [i] = sc.nextDouble();
    }

    System.out.println("\nElementos do vetor:");
    for (double numero : numeros) {
      System.out.println(numero);
    }

    double soma = 0;
    for (double numero : numeros) {
      soma += numero;
    }

    double media = soma / N;

    System.out.printf("\nSoma dos elementos: %.2f%n", soma);
    System.out.printf("Média dos elementos: %.2f%n", media);

    sc.close();
  }
}
