package JavaGenerics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

class Electronics extends WarehouseItem {
    private double power;

    public Electronics(String name, double power) {
        super(name);
        this.power = power;
    }

    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Power: " + power + "W");
    }
}

class Groceries extends WarehouseItem {
    private int quantity;

    public Groceries(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + getName() + ", Quantity: " + quantity);
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class WarehouseUtils {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 65));
        electronicsStorage.addItem(new Electronics("Smartphone", 15));

        groceriesStorage.addItem(new Groceries("Apples", 50));
        groceriesStorage.addItem(new Groceries("Milk", 30));

        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("Electronics Items:");
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Items:");
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());

        System.out.println("\nFurniture Items:");
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}
