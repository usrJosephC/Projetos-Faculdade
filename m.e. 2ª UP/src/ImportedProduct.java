public class ImportedProduct extends Product {
  private double customsFee;

  public ImportedProduct(String name, double price, double customsFee) {
      super(name, price);
      this.customsFee = customsFee;
  }

  public double totalPrice() {
      return price + customsFee;
  }

  @Override
  public String priceTag() {
      return String.format("%s R$%.2f (Taxas: R$%.2f)", name, totalPrice(), customsFee);
  }
}
