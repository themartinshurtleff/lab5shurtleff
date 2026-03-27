/**
 * ShelfStable - Represents a shelf-stable food item in the store.
 * Extends FoodItem.
 * @author Martin Shurtleff
 */
public class ShelfStable extends FoodItem {

    private int shelfLifeMonths;
    private String type;

    public ShelfStable(String name, double price, int quantity, String brand,
                       String description, String expirationDate,
                       int shelfLifeMonths, String type) {
        super(name, price, quantity, brand, description, expirationDate);
        this.shelfLifeMonths = shelfLifeMonths;
        this.type = type;
    }

    public int getShelfLifeMonths() {
        return shelfLifeMonths;
    }

    public void setShelfLifeMonths(int shelfLifeMonths) {
        this.shelfLifeMonths = shelfLifeMonths;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return super.toString() + ", Shelf Life: " + shelfLifeMonths +
               " months, Type: " + type;
    }
}
