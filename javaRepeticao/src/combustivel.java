import java.util.*;

public class combustivel {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int alcool = 0;
    int gasolina = 0;
    int diesel = 0;

    while (true) {
      System.out.println("Informe o tipo de combustível abastecido: ");
      System.out.println("1. Álcool");
      System.out.println("2. Gasolina");
      System.out.println("3. Diesel");
      System.out.println("4. Fim");
      int codigo = sc.nextInt();


      if (codigo == 1) {
        alcool++;
      } else if (codigo == 2) {
        gasolina++;
      } else if (codigo == 3) {
        diesel++;
      } else if (codigo == 4) {
        break;
      } else {
        System.out.println("Código Inválido! Por favor, informe um código válido.");
      }
    }

    System.out.println("Muito Obriado! ;D");
    System.out.println("Quantidade de clientes que abasteceram: ");
    System.out.println("Álcool: " + alcool);
    System.out.println("Gasolina: " + gasolina);
    System.out.println("Diesel: " + diesel);

    sc.close();
  }
}
