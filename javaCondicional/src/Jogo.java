import java.util.*;

public class Jogo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite apenas a hora (sem os minutos) inicial do jogo:");
    int Inicio = sc.nextInt();
    System.out.println("Digite a hora (sem os minutos) final: ");
    int Final = sc.nextInt();

    int Duracao;
    if (Final > Inicio) {
      Duracao = Final - Inicio;
    } else {
      Duracao = (24 - Inicio) + Final;
    }

    System.out.println("A duração do jogo é: " + Duracao + " horas.");
    sc.close();
  }

}
