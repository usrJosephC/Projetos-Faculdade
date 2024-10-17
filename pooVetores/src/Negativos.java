import java.util.*;

public class Negativos {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo (máximo = 10): ");
        int N = sc.nextInt();

        
        if (N < 1 || N > 10) {
            System.out.println("O número deve ser entre 1 e 10.");
            return;
        }


        int[] numeros = new int[N];

        System.out.println("Digite " + N + " números inteiros: ");
        for (int i = 0; i < N; i++) {
            numeros[i] = sc.nextInt();
        }

        System.out.println("Números negativos encontrados: ");
        boolean encontrarNegativo = false;
        for (int numero : numeros) {
            if (numero < 0) {
                System.out.println(numero);
                encontrarNegativo = true;
            }
        }

        if (!encontrarNegativo) {
            System.out.println("Nenhum número negativo foi encontrado.");
        }

        sc.close();
    }
}
