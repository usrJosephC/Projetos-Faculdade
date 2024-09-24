import java.util.*;

public class senha {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int senhaCorreta = 2002;
        int senhaInformada;

        while (true) {
            System.out.print("Digite a senha:");
            senhaInformada = sc.nextInt();
            if (senhaInformada == senhaCorreta){
                System.out.println("Acesso Permitido");
                break;
            } else {
                System.out.println("Senha Inválida");
            }
        }
        sc.close();
    }
}
