import java.util.*;

public class ProductManager {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Insira o número de produtos: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.printf("Dados do %dº Produto:%n", i + 1);
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char productType = sc.nextLine().charAt(0);

            System.out.print("Nome: ");
            String name = sc.nextLine();

            System.out.print("Preço: R$");
            double price = sc.nextDouble();
            sc.nextLine();

            if (productType == 'i') {
                System.out.print("Taxas: R$");
                double customsFee = sc.nextDouble();
                sc.nextLine();
                products.add(new ImportedProduct(name, price, customsFee));
            } else if (productType == 'u') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                String manufactureDate = sc.nextLine();
                products.add(new UsedProduct(name, price, manufactureDate));
            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println("\nETIQUETAS DE PREÇO: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
