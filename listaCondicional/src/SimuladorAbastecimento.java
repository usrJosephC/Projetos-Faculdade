import java.util.*;

public class SimuladorAbastecimento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolhaCombustivel;
        double precoLitro, quantidadeLitros, valorTotal;
        String nomeCombustivel;

        System.out.println("Bem-vindo ao posto de gasolina!");
        System.out.println("Temos os seguintes combustíveis disponíveis:");
        System.out.println("1 - Gasolina (R$ 5,89 por litro)");
        System.out.println("2 - Álcool (R$ 4,79 por litro)");

        System.out.print("Digite o número do combustível desejado (1 ou 2): ");
        escolhaCombustivel = sc.nextInt();

        switch (escolhaCombustivel) {
            case 1:
                precoLitro = 5.89;
                nomeCombustivel = "Gasolina";
                break;
            case 2:
                precoLitro = 4.79;
                nomeCombustivel = "Álcool";
                break;
            default:
                System.out.println("Opção inválida. Abastecimento cancelado.");
                sc.close();
                return;
        }

        System.out.print("Digite quantos litros deseja abastecer: ");
        quantidadeLitros = sc.nextDouble();

        valorTotal = precoLitro * quantidadeLitros;

        System.out.printf("Você escolheu %s%n", nomeCombustivel);
        System.out.printf("Quantidade de litros: %.2f%n", quantidadeLitros);
        System.out.printf("Valor total a ser pago: R$%.2f%n", valorTotal);
        System.out.println("Obrigado por abastecer conosco! Volte sempre! :)");

        sc.close();
    }
}
