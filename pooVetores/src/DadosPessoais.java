import java.util.*;

public class DadosPessoais {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite a quantidade de pessoas: ");
    int N = sc.nextInt();

    double maiorAltura = Double.MIN_VALUE;
    double menorAltura = Double.MAX_VALUE;
    double somaAlturaMulheres = 0.0;
    int contadorMulheres = 0;
    int contadorHomens = 0;

    for (int i = 0; i < N; i++) {
      System.out.print("Digite a altura da " + (i + 1) + "ª pessoa: ");
      double altura = sc.nextDouble();
      System.out.print("Digite o gênero da " + (i + 1) + "ª pessoa(M/F): ");
      char genero = sc.next().charAt(0);

    if (altura > maiorAltura) {
        maiorAltura = altura;
    }
    
    if (altura < menorAltura) {
        menorAltura = altura;
    }

    if (genero == 'F' || genero == 'f') {
      somaAlturaMulheres += altura;
      contadorMulheres++;
      } else if (genero == 'M' || genero == 'm') {
      contadorHomens++;
      }
    }
    double mediaAlturaMulheres = contadorMulheres > 0 ? somaAlturaMulheres / contadorMulheres : 0;

    System.out.printf("Maior altura: %.2f metros%n", maiorAltura);
    System.out.printf("Menor altura: %.2f metros%n", menorAltura);
    System.out.printf("Média de altura das mulheres: %.2f metros%n", mediaAlturaMulheres);
    System.out.println("Número de homens: " + contadorHomens);

    sc.close();
  }
}
