import java.util.*;

public class impar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite um valor inteiro (1 <= x <= 1000): ");
    int x = sc.nextInt();

    if (x < 1 || x > 1000) {
      System.out.println("Valor fora do intervalo permitido.");
  } else {
      
      for (int i = 1; i <= x; i++) {
          if (i % 2 != 0) {
              System.out.println(i);
          }
      }
  }

  sc.close();

  }
}
