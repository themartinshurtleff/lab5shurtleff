/**
 * HouseholdItem - Parent class for all household items.
 * Extends StoreItem. Tax rate: 7%.
 * @author Martin Shurtleff
 */
public class HouseholdItem extends StoreItem {

    private String roomType;

    public HouseholdItem(String name, double price, int quantity, String brand,
                         String description, String roomType) {
        super(name, price, quantity, brand, description,
              "14-day return with receipt.");
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getTaxRate() {
        return 0.07;
    }

    public String toString() {
        return super.toString() + ", Room Type: " + roomType;
    }
}
