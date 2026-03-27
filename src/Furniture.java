/**
 * Furniture - Represents a furniture item in the store.
 * Extends HouseholdItem.
 * @author Martin Shurtleff
 */
public class Furniture extends HouseholdItem {

    private String material;
    private double weight;

    public Furniture(String name, double price, int quantity, String brand,
                     String description, String roomType,
                     String material, double weight) {
        super(name, price, quantity, brand, description, roomType);
        this.material = material;
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return super.toString() + ", Material: " + material +
               ", Weight: " + String.format("%.2f", weight) + " lbs";
    }
}
