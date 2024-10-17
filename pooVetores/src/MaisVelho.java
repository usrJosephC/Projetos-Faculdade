import java.util.*;

public class MaisVelho {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite a quantidade de pessoas: ");
    int N = sc.nextInt();
    sc.nextLine();

    String[] nomes = new String[N];
    int[] idades = new int[N];

    for (int i = 0; i < N; i++) {
      System.out.print("Digite o nome da " + (i + 1) + "ª pessoa: ");
      nomes[i] = sc.nextLine();

      System.out.print("Digite a idade da " + (i + 1) + "ª pessoa: ");
      idades[i] = sc.nextInt();
      sc.nextLine();
    }

    int idadeMaxima = idades[0];
    String nomeMaisVelho = nomes[0];

    for (int i = 1; i < N; i++) {
      if (idades[i] > idadeMaxima) {
        idadeMaxima = idades[i];
        nomeMaisVelho = nomes[i];
      }
    }

    System.out.printf("A pessoa mais velha é %s com %d anos", nomeMaisVelho, idadeMaxima);

    sc.close();
  }
}
