/**
 * ElectronicsItem - Parent class for all electronics.
 * Extends StoreItem. Tax rate: 7%.
 * @author Martin Shurtleff
 */
public class ElectronicsItem extends StoreItem {

    private String warranty;

    public ElectronicsItem(String name, double price, int quantity, String brand,
                           String description, String warranty) {
        super(name, price, quantity, brand, description,
              "30-day return with receipt and original packaging.");
        this.warranty = warranty;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public double getTaxRate() {
        return 0.07;
    }

    public String toString() {
        return super.toString() + ", Warranty: " + warranty;
    }
}
