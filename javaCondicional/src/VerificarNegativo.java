import java.util.*;

public class VerificarNegativo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número  inteiro para verificação: ");
        int x = sc.nextInt();
        
        if (x < 0) {
            System.out.println("O número é negativo.");
        } else {
            System.out.println("O número é positivo.");
        }
        sc.close();
    }
}
