import java.util.*;

public class NumerosPares {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Quantos números você vai digitar: ");
    int N = sc.nextInt();

    int[] numeros = new int[N];

    System.out.println("Digite " + N + " números inteiros:");
    for (int i = 0; i < N; i++) {
      System.out.print("Digite um número: ");
      numeros[i] = sc.nextInt();
    }

    int quantidadePares = 0;
    System.out.println("Números pares:");
    for (int numero : numeros) {
      if (numero % 2 == 0) {
        System.out.println(numero);
        quantidadePares++;
      }
    }

    System.out.println("Quantidade de números pares: " + quantidadePares);

    sc.close();
  }
}
