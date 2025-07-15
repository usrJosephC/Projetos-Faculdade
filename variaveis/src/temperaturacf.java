import java.util.*;

public class temperaturacf {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double celsius, fahrenheit;

        System.out.println("Digite a temperatura em Celsius: ");
        celsius = sc.nextDouble();

        fahrenheit = celsius * 9 / 5 + 32 ;

        System.out.printf("A temperatura em Celsius %.1fº equivale em Fahrenheit a %.1fF%n", celsius, fahrenheit);

        sc.close();
    }
}
