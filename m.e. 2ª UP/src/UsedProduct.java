import java.util.*;
import java.text.*;

public class UsedProduct extends Product {
  private Date manufactureDate;

  public UsedProduct(String name, double price, String manufactureDate) throws ParseException {
    super(name, price);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    this.manufactureDate = sdf.parse(manufactureDate);
  }
    @Override
    public String priceTag() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      return String.format("%s (usado) $%.2f (data de fabricação: %s)", name, price, sdf.format(manufactureDate));
    }
}