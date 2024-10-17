import java.util.*;

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class Produtos {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de produtos: ");
        int N = sc.nextInt();
        sc.nextLine();
    
        Produto[] produtos = new Produto[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Digite o nome do " + (i + 1) + "º produto: ");
            String nome = sc.nextLine();

            System.out.print("Digite o preço do " + (i + 1) + "º produto: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            produtos[i] = new Produto(nome, preco);
        }

        double somaPrecos = 0.0;
        for (Produto produto : produtos) {
            somaPrecos += produto.preco;
        }

        double precoMedio = somaPrecos / N;

        System.out.printf("Preço médio dos produtos: %.2f%n", precoMedio);

       sc.close();
    }
}
