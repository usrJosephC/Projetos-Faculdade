import java.util.*;

class Estudante {
    String nome;
    String email;
    int    quarto;

    public Estudante(String nome, String email, int quarto) {
        this.nome   = nome;
        this.email  = email;
        this.quarto = quarto;
    }
}
    
public class Questao4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Estudante[] quartos = new Estudante[10];

        System.out.print("Digite a quantidade de estudantes que vão alugar quartos (1-10): ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.println("Registro do estudante " + (i + 1) + ":");
            System.out.print("Nome: " );
            String nome  = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Quarto (0-9): ");
            int quarto   = sc.nextInt();
            sc.nextLine();

            if (quarto >= 0 && quarto < 10 && quartos[quarto] == null) {
                quartos[quarto] = new Estudante(nome, email, quarto);
                System.out.println("Quarto " + quarto + " alugado com sucesso!\n");
            } else {
                System.out.println("Quarto inválido ou já ocupado! Tente novamente.\n");
                i--;
            }
        }

        System.out.println("Relatório de ocupação dos quartos:");
        for (int i = 0; i < 10; i++) {
            if (quartos[i] != null) {
                System.out.println("Quarto " + i + ": " + quartos[i].nome + " - " + quartos[i].email);
            } 
        }

        sc.close();
    }
}
