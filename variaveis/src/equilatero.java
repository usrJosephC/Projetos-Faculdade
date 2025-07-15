import java.util.*;

public class equilatero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double lado, area;

    System.out.println("Digite o valor do lado do triângulo equilátero: ");
    lado = sc.nextDouble();

    area = (Math.pow(lado, 2) * Math.sqrt(3)) / 4;

    System.out.printf("O valor da área do triângulo equilátero é %.2f", area);

    sc.close();
  }
}
