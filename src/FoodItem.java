/**
 * FoodItem - Parent class for all food-related items.
 * Extends StoreItem. Tax rate: 2%.
 * @author Martin Shurtleff
 */
public class FoodItem extends StoreItem {

    private String expirationDate;

    public FoodItem(String name, double price, int quantity, String brand,
                    String description, String expirationDate) {
        super(name, price, quantity, brand, description, "No returns on food items.");
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getTaxRate() {
        return 0.02;
    }

    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate;
    }
}
