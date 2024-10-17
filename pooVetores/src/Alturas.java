import java.util.*;

public class Alturas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<String> nomesMenores16 = new ArrayList<>();
    int totalPessoas = 0;
    int totalMenores16 = 0;
    double somaAltura = 0.0;

    System.out.print("Quantas pessoas serão digitas: ");
    int N = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < N; i++) {
      System.out.print("Digite o nome da "  + (i + 1) +  "ª pessoa: ");
      String nome = sc.nextLine();

      System.out.print("Digite a idade da " + ( i+ 1) +  "ª pessoa: ");
      int idade = sc.nextInt();

      System.out.print("Digite a altura da " + (i + 1) +  "ª pessoa (em metros): ");
      double altura = sc.nextDouble();
      sc.nextLine();

      totalPessoas++;
      somaAltura += altura;

      if (idade < 16) {
        totalMenores16++;
        nomesMenores16.add(nome);
      }
    }

    double alturaMedia = somaAltura / totalPessoas;

    double porcentagemMenores16 = ((double) totalMenores16 / totalPessoas) * 100;

    System.out.printf("Altura média das pessoas: %.2f metros%n", alturaMedia);
    System.out.printf("Porcentagem de pessoas com menos de 16 anos: %.2f%%%n", porcentagemMenores16);

    if (!nomesMenores16.isEmpty()) {
      System.out.println("Nomes das pessoas com menos de 16 anos:");
      for (String nome : nomesMenores16) {
        System.out.println(nome);
      } 
    } else {
      System.out.println("Não há pessoas com menos de 16 anos.");
    }

    sc.close();
  }
}
