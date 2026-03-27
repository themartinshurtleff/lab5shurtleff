/**
 * Phone - Represents a phone in the store.
 * Extends ElectronicsItem.
 * @author Martin Shurtleff
 */
public class Phone extends ElectronicsItem {

    private String carrier;
    private double screenSize;

    public Phone(String name, double price, int quantity, String brand,
                 String description, String warranty,
                 String carrier, double screenSize) {
        super(name, price, quantity, brand, description, warranty);
        this.carrier = carrier;
        this.screenSize = screenSize;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String toString() {
        return super.toString() + ", Carrier: " + carrier +
               ", Screen Size: " + screenSize + " inches";
    }
}
