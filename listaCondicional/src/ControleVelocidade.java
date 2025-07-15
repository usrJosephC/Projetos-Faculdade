import java.util.*;

public class ControleVelocidade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int velocidade, limiteVelocidade, excessoVelocidade;
        double multaPorKm, valorMulta;

        System.out.print("Digite a velocidade do carro (em km/h): ");
        velocidade = sc.nextInt();

        limiteVelocidade = 80;
        multaPorKm = 5.00;

        if (velocidade > limiteVelocidade) {
            excessoVelocidade = velocidade - limiteVelocidade;
            valorMulta = excessoVelocidade * multaPorKm;

            System.out.println("Você foi multado!");
            System.out.printf("Velocidade excedida: %dkm/h%n", excessoVelocidade);
            System.out.printf("Valor da multa: R$%.2f%n", valorMulta);
        } else {
            System.out.println("Velocidade dentro do limite permitido.");
        }

        sc.close();
    }
}
