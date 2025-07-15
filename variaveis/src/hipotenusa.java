import java.util.*;

public class hipotenusa {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double c1, c2, hipo;

    System.out.println("Digite o valor do cateto 1: ");
    c1 = sc.nextDouble();

    System.out.println("Digite o valor do cateto 2: ");
    c2 = sc.nextDouble();

    hipo = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));

    System.out.printf("O valor da hipotenusa é %.2f", hipo);

    sc.close();
  }
}
