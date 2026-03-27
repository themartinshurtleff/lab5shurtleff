/**
 * Fruit - Represents a fruit item in the store.
 * Extends FoodItem.
 * @author Martin Shurtleff
 */
public class Fruit extends FoodItem {

    private String season;

    public Fruit(String name, double price, int quantity, String brand,
                 String description, String expirationDate, String season) {
        super(name, price, quantity, brand, description, expirationDate);
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String toString() {
        return super.toString() + ", Season: " + season;
    }
}
