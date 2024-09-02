import java.util.*;

public class Multiplos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o primeiro dígito(A): ");
    int A = sc.nextInt();
    System.out.println("Digite o segundo dígito(B): ");
    int B = sc.nextInt();

    if (A % B == 0 || B % A == 0) {
      System.out.println("São múltiplos.");
    } else {
      System.out.println("Não são múltiplos.");
    }

    sc.close();
  }
}
