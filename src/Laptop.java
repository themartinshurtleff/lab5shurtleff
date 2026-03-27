/**
 * Laptop - Represents a laptop in the store.
 * Extends ElectronicsItem.
 * @author Martin Shurtleff
 */
public class Laptop extends ElectronicsItem {

    private String processor;
    private int ram;

    public Laptop(String name, double price, int quantity, String brand,
                  String description, String warranty,
                  String processor, int ram) {
        super(name, price, quantity, brand, description, warranty);
        this.processor = processor;
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String toString() {
        return super.toString() + ", Processor: " + processor +
               ", RAM: " + ram + " GB";
    }
}
