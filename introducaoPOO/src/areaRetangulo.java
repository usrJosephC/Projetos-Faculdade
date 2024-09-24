import java.util.Scanner;

class Retangulo {
    // Atributos
    private double width;
    private double height;

    // Construtor
    public Retangulo(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Método para calcular a área
    public double Area() {
        return width * height;
    }

    // Método para calcular o perímetro
    public double Perimeter() {
        return 2 * (width + height);
    }

    // Método para calcular a diagonal
    public double Diagonal() {
        return Math.sqrt((width * width) + (height * height));
    }
}

public class areaRetangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos valores de largura e altura
        System.out.print("Digite a largura do retângulo: ");
        double width = scanner.nextDouble();
        
        System.out.print("Digite a altura do retângulo: ");
        double height = scanner.nextDouble();

        // Criação do objeto Retangulo
        Retangulo Retangulo = new Retangulo(width, height);

        // Cálculo e exibição dos resultados
        System.out.printf("Área do retângulo: %.2f%n", Retangulo.Area());
        System.out.printf("Perímetro do retângulo: %.2f%n", Retangulo.Perimeter());
        System.out.printf("Diagonal do retângulo: %.2f%n", Retangulo.Diagonal());

        scanner.close();
    }
}