import java.util.*;

public class TarifaTransporte {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idade;
        double tarifa, tarifaMeia;

        System.out.print("Digite a sua idade: ");
        idade = sc.nextInt();

        tarifa = 4.00; 

        if (idade < 6) {
            System.out.println("Sua passagem é gratuita.");
        } else if (idade > 60) {
            tarifaMeia = tarifa / 2.0; 
            System.out.printf("Sua passagem custa R$%.2f%n", tarifaMeia);
        } else {
            System.out.printf("Sua passagem custa R$%.2f%n", tarifa);
        }

        sc.close();
    }
}
