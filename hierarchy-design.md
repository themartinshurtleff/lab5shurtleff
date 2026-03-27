# Wilmington Quick Shop - Class Hierarchy Design

## Hierarchy Chart

```
                        StoreItem (abstract)
                       /         |          \
                      /          |           \
               FoodItem    ElectronicsItem   HouseholdItem
              /   |   \      /    |    \        /       \
            /     |     \   /     |     \      /         \
        Fruit Vegetable ShelfStable TV Laptop Phone CleaningSupply Furniture
```

## Class Details

### Level 0: StoreItem (abstract)
- **Purpose**: Root parent class for all store items
- **Instance Variables**:
  - `String name`
  - `double price`
  - `int quantity`
  - `String brand`
  - `String description`
  - `String returnPolicy`

---

### Level 1: FoodItem (extends StoreItem)
- **Purpose**: Parent for all food-related items
- **Instance Variables (additional)**:
  - `String expirationDate`
  - `boolean organic`
- **Tax Rate**: 2% (grocery rate)
- **Return Policy**: "No returns on food items."

### Level 1: ElectronicsItem (extends StoreItem)
- **Purpose**: Parent for all electronics
- **Instance Variables (additional)**:
  - `String warranty`
  - `String powerType`
- **Tax Rate**: 7% (standard rate)
- **Return Policy**: "30-day return with receipt and original packaging."

### Level 1: HouseholdItem (extends StoreItem)
- **Purpose**: Parent for all household items
- **Instance Variables (additional)**:
  - `String roomType`
- **Tax Rate**: 7% (standard rate)
- **Return Policy**: "14-day return with receipt."

---

### Level 2 — Food Items

#### Fruit (extends FoodItem)
- **Instance Variables (additional)**:
  - `String season`
  - `boolean preCut`

#### Vegetable (extends FoodItem)
- **Instance Variables (additional)**:
  - `boolean leafy`
  - `double weight`

#### ShelfStable (extends FoodItem)
- **Instance Variables (additional)**:
  - `int shelfLifeMonths`
  - `String type` (canned, boxed, bagged, etc.)

---

### Level 2 — Electronics Items

#### TV (extends ElectronicsItem)
- **Instance Variables (additional)**:
  - `int screenSize`
  - `String resolution`
  - `boolean smartTV`

#### Laptop (extends ElectronicsItem)
- **Instance Variables (additional)**:
  - `String processor`
  - `int ram`
  - `int storageGB`

#### Phone (extends ElectronicsItem)
- **Instance Variables (additional)**:
  - `String carrier`
  - `double screenSize`
  - `int storageGB`

---

### Level 2 — Household Items

#### CleaningSupply (extends HouseholdItem)
- **Instance Variables (additional)**:
  - `String scent`
  - `boolean hazardous`
  - `String surfaceType`

#### Furniture (extends HouseholdItem)
- **Instance Variables (additional)**:
  - `String material`
  - `double weight`
  - `boolean assemblyRequired`

---

## Tax Rates
| Category      | Tax Rate |
|---------------|----------|
| Food          | 2%       |
| Electronics   | 7%       |
| Household     | 7%       |

## Polymorphism Notes
- All items stored in `ArrayList<StoreItem>` collections
- Overridden `toString()` in each class for display
- Category-specific behavior accessed through parent references
- Tax calculation varies by item type through method overriding
