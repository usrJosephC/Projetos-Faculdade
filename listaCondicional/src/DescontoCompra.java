import java.util.*;

public class DescontoCompra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double desconto, valorCompra, valorFinal;

        System.out.print("Digite o valor total da compra: R$");
        valorCompra = sc.nextDouble();

        if (valorCompra > 100) {
            desconto = valorCompra * 0.10;
            valorFinal = valorCompra - desconto; 

            System.out.printf("Valor original da compra: R$%.2f%n", valorCompra);
            System.out.printf("Desconto aplicado: R$%.2f%n", desconto);
            System.out.printf("Valor final com desconto: R$%.2f%n", valorFinal);
        } else {
            System.out.printf("Valor total da compra: R$%.2f%n", valorCompra);
            System.out.println("Não há desconto aplicado, pois a compra não atingiu R$100.");
        }

        sc.close();
    }
}
