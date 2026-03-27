/**
 * Vegetable - Represents a vegetable item in the store.
 * Extends FoodItem.
 * @author Martin Shurtleff
 */
public class Vegetable extends FoodItem {

    private double weight;

    public Vegetable(String name, double price, int quantity, String brand,
                     String description, String expirationDate, double weight) {
        super(name, price, quantity, brand, description, expirationDate);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + ", Weight: " + String.format("%.2f", weight) + " lbs";
    }
}
