import java.util.ArrayList;
import java.util.Scanner;

/**
 * WQSShurtleff - Driver program for the Wilmington Quick Shop.
 * Manages inventory and sales for a store with Food, Electronics,
 * and Household items.
 *
 * Polymorphism is used in this program in the following ways:
 * 1. All items are stored in ArrayList<StoreItem> - parent type holds child objects.
 * 2. toString() is called on StoreItem references but executes the child class version.
 * 3. getTaxRate() is called on StoreItem references but returns the rate from the child class.
 * 4. getReturnPolicy() is called on StoreItem references but returns the policy set by the child class.
 *
 * @author Martin Shurtleff
 */
public class WQSShurtleff {

    // Polymorphism: ArrayLists use parent type StoreItem to hold child objects
    private static ArrayList<StoreItem> foodInventory = new ArrayList<StoreItem>();
    private static ArrayList<StoreItem> electronicsInventory = new ArrayList<StoreItem>();
    private static ArrayList<StoreItem> householdInventory = new ArrayList<StoreItem>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeInventory();

        System.out.println("========================================");
        System.out.println("   Welcome to Wilmington Quick Shop!");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Sell an item");
            System.out.println("2. Add an item to inventory");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    sellItem();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    running = false;
                    System.out.println("\nThank you for visiting Wilmington Quick Shop!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Initializes the store with starting inventory.
     * At least one instance of each bottom-level class is created.
     */
    private static void initializeInventory() {
        // Food items - Fruit, Vegetable, ShelfStable
        foodInventory.add(new Fruit("Strawberries", 3.99, 50, "Dole",
                "Fresh strawberries", "04/15/2026", "Spring"));
        foodInventory.add(new Fruit("Bananas", 0.59, 100, "Chiquita",
                "Fresh bananas", "04/05/2026", "Year-round"));
        foodInventory.add(new Vegetable("Broccoli", 1.99, 40, "Green Giant",
                "Fresh broccoli crowns", "04/10/2026", 1.5));
        foodInventory.add(new Vegetable("Carrots", 1.49, 60, "Bolthouse Farms",
                "Baby carrots", "04/20/2026", 2.0));
        foodInventory.add(new ShelfStable("Chicken Soup", 2.49, 80, "Campbell's",
                "Classic chicken noodle soup", "12/01/2027", 24, "Canned"));
        foodInventory.add(new ShelfStable("Mac and Cheese", 1.29, 100, "Kraft",
                "Original mac and cheese", "06/01/2027", 18, "Boxed"));

        // Electronics items - TV, Laptop, Phone
        electronicsInventory.add(new TV("4K Smart TV", 399.99, 15, "Samsung",
                "55 inch 4K television", "2 years", 55));
        electronicsInventory.add(new TV("LED TV", 249.99, 20, "LG",
                "43 inch LED television", "1 year", 43));
        electronicsInventory.add(new Laptop("MacBook Air", 999.99, 10, "Apple",
                "Lightweight laptop", "1 year", "M2", 8));
        electronicsInventory.add(new Laptop("Inspiron 15", 549.99, 12, "Dell",
                "Budget-friendly laptop", "1 year", "Intel i5", 16));
        electronicsInventory.add(new Phone("iPhone 15", 799.99, 25, "Apple",
                "Latest iPhone model", "1 year", "Verizon", 6.1));
        electronicsInventory.add(new Phone("Galaxy S24", 749.99, 20, "Samsung",
                "Latest Galaxy model", "1 year", "T-Mobile", 6.2));

        // Household items - CleaningSupply, Furniture
        householdInventory.add(new CleaningSupply("All-Purpose Cleaner", 4.99, 30, "Lysol",
                "Spray cleaner for surfaces", "Kitchen", "Multi-surface"));
        householdInventory.add(new CleaningSupply("Glass Cleaner", 3.99, 25, "Windex",
                "Streak-free glass cleaner", "Bathroom", "Glass"));
        householdInventory.add(new Furniture("Bookshelf", 89.99, 8, "IKEA",
                "5-shelf bookcase", "Living Room", "Wood", 45.0));
        householdInventory.add(new Furniture("Office Chair", 149.99, 10, "Flash Furniture",
                "Ergonomic desk chair", "Office", "Mesh", 30.0));
    }

    /**
     * Handles the selling process.
     * Uses polymorphism when displaying items and calculating tax.
     */
    private static void sellItem() {
        ArrayList<StoreItem> order = new ArrayList<StoreItem>(); // Polymorphism: parent type holds child objects

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nWhat category would you like to shop for?");
            System.out.println("1. Food");
            System.out.println("2. Electronics");
            System.out.println("3. Household");
            System.out.print("Enter choice: ");
            int categoryChoice = getIntInput();

            ArrayList<StoreItem> selectedInventory;
            String categoryName;

            switch (categoryChoice) {
                case 1:
                    selectedInventory = foodInventory;
                    categoryName = "Food";
                    break;
                case 2:
                    selectedInventory = electronicsInventory;
                    categoryName = "Electronics";
                    break;
                case 3:
                    selectedInventory = householdInventory;
                    categoryName = "Household";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            // Display available items in table format
            // Polymorphism: toString(), getBrand(), getReturnPolicy() called on StoreItem references
            System.out.println("\n--- " + categoryName + " Items Available ---");
            System.out.printf("%-4s %-20s %-10s %-15s %-6s %-30s %-45s\n",
                    "#", "Name", "Price", "Brand", "Qty", "Description", "Return Policy");
            System.out.println("-".repeat(130));

            for (int i = 0; i < selectedInventory.size(); i++) {
                StoreItem item = selectedInventory.get(i); // Polymorphism: StoreItem reference to child object
                System.out.printf("%-4d %-20s $%-9.2f %-15s %-6d %-30s %-45s\n",
                        (i + 1), item.getName(), item.getPrice(), item.getBrand(),
                        item.getQuantity(), item.getDescription(), item.getReturnPolicy());
            }

            System.out.print("\nEnter item number to add to order (0 to stop shopping): ");
            int itemChoice = getIntInput();

            if (itemChoice == 0) {
                shopping = false;
            } else if (itemChoice >= 1 && itemChoice <= selectedInventory.size()) {
                StoreItem selectedItem = selectedInventory.get(itemChoice - 1);

                if (selectedItem.getQuantity() <= 0) {
                    System.out.println("Sorry, that item is out of stock.");
                } else {
                    System.out.print("How many would you like? ");
                    int qty = getIntInput();

                    if (qty > selectedItem.getQuantity()) {
                        System.out.println("Sorry, only " + selectedItem.getQuantity() + " available.");
                    } else if (qty > 0) {
                        // Check if item is already in the order
                        boolean found = false;
                        for (StoreItem orderItem : order) {
                            if (orderItem.getName().equals(selectedItem.getName())) {
                                orderItem.setQuantity(orderItem.getQuantity() + qty);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            // Create a copy for the order with the requested quantity
                            StoreItem orderCopy = createOrderCopy(selectedItem, qty);
                            order.add(orderCopy);
                        }

                        selectedItem.setQuantity(selectedItem.getQuantity() - qty);
                        System.out.println(qty + " x " + selectedItem.getName() + " added to order.");
                    }
                }

                System.out.print("\nContinue shopping? (yes/no): ");
                String cont = scanner.nextLine().trim().toLowerCase();
                if (cont.equals("no") || cont.equals("n")) {
                    shopping = false;
                }
            } else {
                System.out.println("Invalid item number.");
            }
        }

        // Display order summary and checkout
        if (order.isEmpty()) {
            System.out.println("\nYour order is empty.");
            return;
        }

        displayOrderSummary(order);

        System.out.print("\nConfirm checkout? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            double subtotal = 0;
            double totalTax = 0;

            // Polymorphism: getTaxRate() called on StoreItem references
            // returns 0.02 for FoodItem children, 0.07 for Electronics/Household children
            for (StoreItem item : order) {
                double itemTotal = item.getPrice() * item.getQuantity();
                double itemTax = itemTotal * item.getTaxRate(); // Polymorphism: getTaxRate()
                subtotal += itemTotal;
                totalTax += itemTax;
            }

            double grandTotal = subtotal + totalTax;

            System.out.println("\n========================================");
            System.out.println("           RECEIPT");
            System.out.println("========================================");
            for (StoreItem item : order) {
                System.out.printf("%-20s x%-3d  $%.2f\n",
                        item.getName(), item.getQuantity(),
                        item.getPrice() * item.getQuantity());
            }
            System.out.println("----------------------------------------");
            System.out.printf("Subtotal:              $%.2f\n", subtotal);
            System.out.printf("Tax:                   $%.2f\n", totalTax);
            System.out.printf("Total:                 $%.2f\n", grandTotal);
            System.out.println("========================================");

            // Display updated inventory for sold categories
            displayUpdatedInventory(order);

            // Display return policies for item categories sold
            displayReturnPolicies(order);
        } else {
            System.out.println("Checkout cancelled. Items returned to inventory.");
            // Return quantities to inventory
            for (StoreItem orderItem : order) {
                returnToInventory(orderItem);
            }
        }
    }

    /**
     * Handles adding items to inventory.
     */
    private static void addItem() {
        boolean adding = true;
        while (adding) {
            System.out.println("\nWhat type of item would you like to add?");
            System.out.println("1. Food");
            System.out.println("2. Electronics");
            System.out.println("3. Household");
            System.out.print("Enter choice: ");
            int categoryChoice = getIntInput();

            ArrayList<StoreItem> selectedInventory;
            String categoryName;

            switch (categoryChoice) {
                case 1:
                    selectedInventory = foodInventory;
                    categoryName = "Food";
                    break;
                case 2:
                    selectedInventory = electronicsInventory;
                    categoryName = "Electronics";
                    break;
                case 3:
                    selectedInventory = householdInventory;
                    categoryName = "Household";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            // Display current inventory for selected category
            System.out.println("\n--- Current " + categoryName + " Inventory ---");
            for (int i = 0; i < selectedInventory.size(); i++) {
                // Polymorphism: toString() called on StoreItem reference executes child version
                System.out.println((i + 1) + ". " + selectedInventory.get(i).toString());
            }

            System.out.println("\nWould you like to:");
            System.out.println("1. Add more of an existing item");
            System.out.println("2. Create a new item");
            System.out.print("Enter choice: ");
            int addChoice = getIntInput();

            if (addChoice == 1) {
                System.out.print("Enter item number: ");
                int itemNum = getIntInput();
                if (itemNum >= 1 && itemNum <= selectedInventory.size()) {
                    System.out.print("How many to add? ");
                    int qty = getIntInput();
                    StoreItem item = selectedInventory.get(itemNum - 1);
                    item.setQuantity(item.getQuantity() + qty);
                    System.out.println("Updated! " + item.getName() + " now has " + item.getQuantity() + " in stock.");
                } else {
                    System.out.println("Invalid item number.");
                }
            } else if (addChoice == 2) {
                StoreItem newItem = createNewItem(categoryChoice);
                if (newItem != null) {
                    selectedInventory.add(newItem); // Polymorphism: adding child object to StoreItem list
                    System.out.println("New item added: " + newItem.getName());
                }
            } else {
                System.out.println("Invalid choice.");
            }

            // Display updated inventory
            System.out.println("\n--- Updated " + categoryName + " Inventory ---");
            for (int i = 0; i < selectedInventory.size(); i++) {
                // Polymorphism: toString() on StoreItem reference
                System.out.println((i + 1) + ". " + selectedInventory.get(i).toString());
            }

            System.out.print("\nAdd more items? (yes/no): ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (cont.equals("no") || cont.equals("n")) {
                adding = false;
            }
        }
    }

    /**
     * Creates a new item based on user input and category.
     * @param category 1=Food, 2=Electronics, 3=Household
     * @return the new StoreItem, or null if invalid
     */
    private static StoreItem createNewItem(int category) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter price: ");
        double price = getDoubleInput();
        System.out.print("Enter quantity: ");
        int quantity = getIntInput();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine().trim();
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        if (category == 1) {
            System.out.print("Enter expiration date: ");
            String expDate = scanner.nextLine().trim();

            System.out.println("What type of food item?");
            System.out.println("1. Fruit");
            System.out.println("2. Vegetable");
            System.out.println("3. Shelf Stable");
            System.out.print("Enter choice: ");
            int type = getIntInput();

            switch (type) {
                case 1:
                    System.out.print("Enter season: ");
                    String season = scanner.nextLine().trim();
                    return new Fruit(name, price, quantity, brand, description, expDate, season);
                case 2:
                    System.out.print("Enter weight (lbs): ");
                    double weight = getDoubleInput();
                    return new Vegetable(name, price, quantity, brand, description, expDate, weight);
                case 3:
                    System.out.print("Enter shelf life (months): ");
                    int shelfLife = getIntInput();
                    System.out.print("Enter type (Canned/Boxed/Bagged): ");
                    String shelfType = scanner.nextLine().trim();
                    return new ShelfStable(name, price, quantity, brand, description, expDate, shelfLife, shelfType);
                default:
                    System.out.println("Invalid food type.");
                    return null;
            }
        } else if (category == 2) {
            System.out.print("Enter warranty: ");
            String warranty = scanner.nextLine().trim();

            System.out.println("What type of electronics item?");
            System.out.println("1. TV");
            System.out.println("2. Laptop");
            System.out.println("3. Phone");
            System.out.print("Enter choice: ");
            int type = getIntInput();

            switch (type) {
                case 1:
                    System.out.print("Enter screen size (inches): ");
                    int screenSize = getIntInput();
                    return new TV(name, price, quantity, brand, description, warranty, screenSize);
                case 2:
                    System.out.print("Enter processor: ");
                    String processor = scanner.nextLine().trim();
                    System.out.print("Enter RAM (GB): ");
                    int ram = getIntInput();
                    return new Laptop(name, price, quantity, brand, description, warranty, processor, ram);
                case 3:
                    System.out.print("Enter carrier: ");
                    String carrier = scanner.nextLine().trim();
                    System.out.print("Enter screen size (inches): ");
                    double phoneScreen = getDoubleInput();
                    return new Phone(name, price, quantity, brand, description, warranty, carrier, phoneScreen);
                default:
                    System.out.println("Invalid electronics type.");
                    return null;
            }
        } else if (category == 3) {
            System.out.print("Enter room type: ");
            String roomType = scanner.nextLine().trim();

            System.out.println("What type of household item?");
            System.out.println("1. Cleaning Supply");
            System.out.println("2. Furniture");
            System.out.print("Enter choice: ");
            int type = getIntInput();

            switch (type) {
                case 1:
                    System.out.print("Enter surface type: ");
                    String surfaceType = scanner.nextLine().trim();
                    return new CleaningSupply(name, price, quantity, brand, description, roomType, surfaceType);
                case 2:
                    System.out.print("Enter material: ");
                    String material = scanner.nextLine().trim();
                    System.out.print("Enter weight (lbs): ");
                    double furnitureWeight = getDoubleInput();
                    return new Furniture(name, price, quantity, brand, description, roomType, material, furnitureWeight);
                default:
                    System.out.println("Invalid household type.");
                    return null;
            }
        }
        return null;
    }

    /**
     * Creates a copy of a StoreItem for the order with the specified quantity.
     * Uses instanceof to determine the actual type - this works alongside polymorphism.
     */
    private static StoreItem createOrderCopy(StoreItem item, int qty) {
        if (item instanceof Fruit) {
            Fruit f = (Fruit) item;
            return new Fruit(f.getName(), f.getPrice(), qty, f.getBrand(),
                    f.getDescription(), f.getExpirationDate(), f.getSeason());
        } else if (item instanceof Vegetable) {
            Vegetable v = (Vegetable) item;
            return new Vegetable(v.getName(), v.getPrice(), qty, v.getBrand(),
                    v.getDescription(), v.getExpirationDate(), v.getWeight());
        } else if (item instanceof ShelfStable) {
            ShelfStable s = (ShelfStable) item;
            return new ShelfStable(s.getName(), s.getPrice(), qty, s.getBrand(),
                    s.getDescription(), s.getExpirationDate(), s.getShelfLifeMonths(), s.getType());
        } else if (item instanceof TV) {
            TV t = (TV) item;
            return new TV(t.getName(), t.getPrice(), qty, t.getBrand(),
                    t.getDescription(), t.getWarranty(), t.getScreenSize());
        } else if (item instanceof Laptop) {
            Laptop l = (Laptop) item;
            return new Laptop(l.getName(), l.getPrice(), qty, l.getBrand(),
                    l.getDescription(), l.getWarranty(), l.getProcessor(), l.getRam());
        } else if (item instanceof Phone) {
            Phone p = (Phone) item;
            return new Phone(p.getName(), p.getPrice(), qty, p.getBrand(),
                    p.getDescription(), p.getWarranty(), p.getCarrier(), p.getScreenSize());
        } else if (item instanceof CleaningSupply) {
            CleaningSupply c = (CleaningSupply) item;
            return new CleaningSupply(c.getName(), c.getPrice(), qty, c.getBrand(),
                    c.getDescription(), c.getRoomType(), c.getSurfaceType());
        } else if (item instanceof Furniture) {
            Furniture fu = (Furniture) item;
            return new Furniture(fu.getName(), fu.getPrice(), qty, fu.getBrand(),
                    fu.getDescription(), fu.getRoomType(), fu.getMaterial(), fu.getWeight());
        }
        return null;
    }

    /**
     * Returns items to inventory when checkout is cancelled.
     */
    private static void returnToInventory(StoreItem orderItem) {
        ArrayList<StoreItem> inventory;
        if (orderItem instanceof FoodItem) {
            inventory = foodInventory;
        } else if (orderItem instanceof ElectronicsItem) {
            inventory = electronicsInventory;
        } else {
            inventory = householdInventory;
        }

        for (StoreItem invItem : inventory) {
            if (invItem.getName().equals(orderItem.getName())) {
                invItem.setQuantity(invItem.getQuantity() + orderItem.getQuantity());
                return;
            }
        }
    }

    /**
     * Displays the order summary grouped by item category.
     * Polymorphism: uses instanceof to check type, but items are stored as StoreItem.
     */
    private static void displayOrderSummary(ArrayList<StoreItem> order) {
        System.out.println("\n========================================");
        System.out.println("         ORDER SUMMARY");
        System.out.println("========================================");

        // Group by category - Food items first
        boolean hasFood = false, hasElectronics = false, hasHousehold = false;

        for (StoreItem item : order) {
            if (item instanceof FoodItem) hasFood = true;
            if (item instanceof ElectronicsItem) hasElectronics = true;
            if (item instanceof HouseholdItem) hasHousehold = true;
        }

        if (hasFood) {
            System.out.println("\n-- Food Items (Tax: 2%) --");
            for (StoreItem item : order) {
                if (item instanceof FoodItem) {
                    System.out.printf("  %-20s x%-3d  $%.2f\n",
                            item.getName(), item.getQuantity(),
                            item.getPrice() * item.getQuantity());
                }
            }
        }

        if (hasElectronics) {
            System.out.println("\n-- Electronics Items (Tax: 7%) --");
            for (StoreItem item : order) {
                if (item instanceof ElectronicsItem) {
                    System.out.printf("  %-20s x%-3d  $%.2f\n",
                            item.getName(), item.getQuantity(),
                            item.getPrice() * item.getQuantity());
                }
            }
        }

        if (hasHousehold) {
            System.out.println("\n-- Household Items (Tax: 7%) --");
            for (StoreItem item : order) {
                if (item instanceof HouseholdItem) {
                    System.out.printf("  %-20s x%-3d  $%.2f\n",
                            item.getName(), item.getQuantity(),
                            item.getPrice() * item.getQuantity());
                }
            }
        }
    }

    /**
     * Displays updated inventory for categories that had items sold.
     */
    private static void displayUpdatedInventory(ArrayList<StoreItem> order) {
        boolean hasFood = false, hasElectronics = false, hasHousehold = false;

        for (StoreItem item : order) {
            if (item instanceof FoodItem) hasFood = true;
            if (item instanceof ElectronicsItem) hasElectronics = true;
            if (item instanceof HouseholdItem) hasHousehold = true;
        }

        System.out.println("\n--- Updated Inventory ---");

        if (hasFood) {
            System.out.println("\nFood:");
            for (int i = 0; i < foodInventory.size(); i++) {
                // Polymorphism: toString() on StoreItem reference
                System.out.println("  " + (i + 1) + ". " + foodInventory.get(i).toString());
            }
        }

        if (hasElectronics) {
            System.out.println("\nElectronics:");
            for (int i = 0; i < electronicsInventory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + electronicsInventory.get(i).toString());
            }
        }

        if (hasHousehold) {
            System.out.println("\nHousehold:");
            for (int i = 0; i < householdInventory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + householdInventory.get(i).toString());
            }
        }
    }

    /**
     * Displays return policies for item categories that were sold.
     * Polymorphism: getReturnPolicy() on StoreItem reference returns the policy
     * set by the specific child class constructor.
     */
    private static void displayReturnPolicies(ArrayList<StoreItem> order) {
        boolean hasFood = false, hasElectronics = false, hasHousehold = false;

        for (StoreItem item : order) {
            if (item instanceof FoodItem) hasFood = true;
            if (item instanceof ElectronicsItem) hasElectronics = true;
            if (item instanceof HouseholdItem) hasHousehold = true;
        }

        System.out.println("\n--- Return Policies ---");
        if (hasFood) {
            System.out.println("Food: " + foodInventory.get(0).getReturnPolicy());
        }
        if (hasElectronics) {
            System.out.println("Electronics: " + electronicsInventory.get(0).getReturnPolicy());
        }
        if (hasHousehold) {
            System.out.println("Household: " + householdInventory.get(0).getReturnPolicy());
        }
    }

    /**
     * Reads an integer from the user, handling invalid input.
     */
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    /**
     * Reads a double from the user, handling invalid input.
     */
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}
