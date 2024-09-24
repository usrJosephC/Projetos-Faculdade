import java.util.*;

public class coordenadas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while (true) {
      System.out.println("Para sair do programa digite como coordenada X = 0 e Y = 0.");
      System.out.print("Digite a coordenada X: ");
      double x = sc.nextDouble();
      System.out.print("Digite a coordenada Y:");
      double y = sc.nextDouble();

      if (x == 0 || y == 0) {
        break;
      } if (x> 0 && y > 0) {
        System.out.println("O ponto (" + x + "," + y + ") está no Quadrante I.");
      } else if (x < 0 && y > 0) {
        System.out.println("O ponto (" + x + ", " + y + ") está no Quadrante II.");
    } else if (x < 0 && y < 0) {
        System.out.println("O ponto (" + x + ", " + y + ") está no Quadrante III.");
    } else if (x > 0 && y < 0) {
        System.out.println("O ponto (" + x + ", " + y + ") está no Quadrante IV.");
    }
    }

    sc.close();

    }
  }
