import java.util.*;

public class ParOuImpar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite um número inteiro:");
    int x = sc.nextInt();
     
     if (x % 2 == 0){
      System.out.println("O número é par.");
    } else {
      System.out.println("O número é ímpar.");
    }

    sc.close();
  }
}
