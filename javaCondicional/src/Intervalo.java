import java.util.*;

public class Intervalo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um valor: ");
    double valor = sc.nextDouble();

    if (valor >= 0 && valor <= 25) {
      System.out.println("O valor está no intervalo [0, 25].");
    } else if (valor > 25 && valor <= 50 ) {
      System.out.println("O valor está no intervalo [25, 50].");
    } else if (valor > 50 && valor <= 75) {
      System.out.println("O valor está no intervalo [50, 75].");
    } else if (valor > 70 && valor <= 100) {
      System.out.println("O valor está no intervalo [70, 100].");
    } else {
      System.out.println("Fora de intervalor.");
    }
    
    sc.close();
  }
}
