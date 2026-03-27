/**
 * TV - Represents a television in the store.
 * Extends ElectronicsItem.
 * @author Martin Shurtleff
 */
public class TV extends ElectronicsItem {

    private int screenSize;

    public TV(String name, double price, int quantity, String brand,
              String description, String warranty, int screenSize) {
        super(name, price, quantity, brand, description, warranty);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String toString() {
        return super.toString() + ", Screen Size: " + screenSize + " inches";
    }
}
