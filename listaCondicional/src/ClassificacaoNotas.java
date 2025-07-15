import java.util.*;

public class ClassificacaoNotas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota;

        System.out.print("Digite a nota do aluno: ");
        nota = sc.nextDouble();

        if (nota < 5) {
            System.out.println("Reprovado");
        } else if (nota >= 5 && nota <= 6.9) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Aprovado");
        }

        sc.close();
    }
}
