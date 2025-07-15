import java.util.*;

public class temperaturack {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double celsius, kelvin;

    System.out.println("Digite a temperatura em Celsius: ");
    celsius = sc.nextDouble();
    
    kelvin = celsius + 273.15;

    System.out.printf("A temperatura em Celsius %.1fº equivale em Kelvin a %.2fK", celsius, kelvin);

    sc.close();
  }
}
