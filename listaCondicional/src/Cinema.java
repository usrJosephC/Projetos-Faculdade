import java.util.*;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idade;

        System.out.println("Bem-vindo ao cinema IF Studio!");
        System.out.print("Por favor, digite sua idade: ");

        idade = sc.nextInt();

        if (idade >= 18) {
            System.out.println("Você pode entrar na sessão. Bom filme!");
        } else {
            System.out.println("Desculpe, você não tem idade suficiente para assistir a este filme.");
        }

        sc.close();
    }
}
