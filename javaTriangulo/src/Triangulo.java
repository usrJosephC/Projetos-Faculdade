import java.util.*;

public class Triangulo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite as medidas dos lados do triângulo X");
        System.out.println("Digite a medida do primeiro lado: ");
        double ladoX1 = sc.nextDouble();
        System.out.println("Digite a medida do segundo lado: ");
        double ladoX2 = sc.nextDouble();
        System.out.println("Digite a medida do terceiro e último lado: ");
        double ladoX3 = sc.nextDouble();
        
        System.out.println("Digite as medidas dos lados do triângulo Y");
        System.out.println("Qual a medida do primeiro lado: ");
        double ladoY1 = sc.nextDouble();
        System.out.println("Qual a medida do segundo lado: ");
        double ladoY2 = sc.nextDouble();
        System.out.println("Qual a medida do terceiro e último lado: ");
        double ladoY3 = sc.nextDouble();
    
        double areaX = area(ladoX1, ladoX2, ladoX3);
        double areaY = area(ladoY1, ladoY2, ladoY3);

        System.out.println("Área do triângulo X: " + areaX);
        System.out.println("Área do triângulo Y: " + areaY);
    
        if (areaX > areaY) {
            System.out.println("O triângulo X possui a maior área.");
        } else if (areaY > areaX) {
            System.out.println("O triângulo Y possui a maior área.");
        } else {
            System.out.println("Os triângulos possuem a mesma área.");
        }
    }

    public static double area(double a, double b, double c) {
        double perimetro = (a + b + c) / 2;
        return Math.sqrt(perimetro * (perimetro - a) * (perimetro - b) * (perimetro - c));
    
    }
}
