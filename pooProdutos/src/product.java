import java.util.Scanner;

class Product {
  
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double TotalValueInStock() {
        return price * quantity;
    }

    public void AddProducts(int quantity) {
        this.quantity += quantity;
    }

    public void RemoveProducts(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return name + ", $" + String.format("%.2f", price) + ", " + quantity 
                + " units, Total: $" + String.format("%.2f", TotalValueInStock());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os dados do produto:");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Preço: ");
        double price = sc.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println();
        System.out.println("Dados do produto: " + product);

        System.out.println();
        System.out.print("Insira a quantidade de produtos a serem adicionado no estoque: ");
        int addQuantity = sc.nextInt();
        product.AddProducts(addQuantity);

        System.out.println("Atualização dos dados: " + product);

        System.out.println();
        System.out.print("Insira a quantidade de produtos a serem removidos no estoque: ");
        int removeQuantity = sc.nextInt();
        product.RemoveProducts(removeQuantity);

        System.out.println("Atualização dos dados: " + product);

        sc.close();
    }
}
