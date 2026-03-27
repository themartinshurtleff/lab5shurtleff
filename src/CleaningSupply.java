/**
 * CleaningSupply - Represents a cleaning supply in the store.
 * Extends HouseholdItem.
 * @author Martin Shurtleff
 */
public class CleaningSupply extends HouseholdItem {

    private String surfaceType;

    public CleaningSupply(String name, double price, int quantity, String brand,
                          String description, String roomType,
                          String surfaceType) {
        super(name, price, quantity, brand, description, roomType);
        this.surfaceType = surfaceType;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public String toString() {
        return super.toString() + ", Surface Type: " + surfaceType;
    }
}
