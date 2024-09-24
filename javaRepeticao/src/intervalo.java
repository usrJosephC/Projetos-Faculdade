import java.util.*;

public class intervalo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de valores (N): ");
        int n = scanner.nextInt();
        
        int dentroIntervalo = 0; 
        int foraIntervalo = 0;   

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um valor inteiro (X): ");
            int x = scanner.nextInt();

           if (x >= 10 && x <= 20) {
                dentroIntervalo++;
            } else {
                foraIntervalo++;
            }
        }

        System.out.println(dentroIntervalo + " in");
        System.out.println(foraIntervalo + " out");

        scanner.close();
  }
}
