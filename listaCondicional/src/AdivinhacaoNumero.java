import java.util.*;

public class AdivinhacaoNumero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio, tentativas, palpite;

        numeroAleatorio = random.nextInt(10) + 1;
        tentativas = 0;

        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Tente adivinhar o número que estou pensando (entre 1 e 10):");

        while (true) {
            tentativas++;
            System.out.print("Digite seu palpite: ");
            palpite = sc.nextInt();

            if (palpite == numeroAleatorio) {
                System.out.printf("Parabéns, você acertou! O número era: %d%n", numeroAleatorio);
                System.out.printf("Você adivinhou em %d tentativas.%n",  tentativas);
                break;
            } else if (palpite < numeroAleatorio) {
                System.out.println("O número é maior.");
            } else {
                System.out.println("O número é menor.");
            }
        }

        sc.close();
    }
}
