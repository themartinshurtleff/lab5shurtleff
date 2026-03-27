/**
 * StoreItem - Abstract parent class for all store items.
 * @author Martin Shurtleff
 */
public abstract class StoreItem {

    private String name;
    private double price;
    private int quantity;
    private String brand;
    private String description;
    private String returnPolicy;

    public StoreItem(String name, double price, int quantity, String brand,
                     String description, String returnPolicy) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
        this.returnPolicy = returnPolicy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public abstract double getTaxRate();

    public String toString() {
        return "Name: " + name + ", Price: $" + String.format("%.2f", price) +
               ", Quantity: " + quantity + ", Brand: " + brand +
               ", Description: " + description;
    }
}
