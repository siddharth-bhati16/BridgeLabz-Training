package src.linkedlist.Singlylinkedlist;

class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    Item head;

    /* Add at beginning */
    void addAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    /* Add at end */
    void addAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newItem;
    }

    /* Add at specific position (1-based) */
    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    /* Remove item by ID */
    void removeById(int id) {
        if (head == null)
            return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Item removed.");
    }

    /* Update quantity by ID */
    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    /* Search by ID */
    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    /* Search by Name */
    void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    /* Calculate total inventory value */
    void totalInventoryValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    /* Sort by name or price */
    void sort(String key, boolean ascending) {
        if (head == null)
            return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean condition = false;

                if (key.equalsIgnoreCase("name")) {
                    condition = ascending
                            ? i.itemName.compareToIgnoreCase(j.itemName) > 0
                            : i.itemName.compareToIgnoreCase(j.itemName) < 0;
                } else if (key.equalsIgnoreCase("price")) {
                    condition = ascending ? i.price > j.price : i.price < j.price;
                }

                if (condition) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by " + key);
    }

    /* Swap item data */
    void swapData(Item a, Item b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    /* Display all items */
    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    void displayItem(Item item) {
        System.out.println(
            item.itemId + " | " +
            item.itemName + " | Qty: " +
            item.quantity + " | Price: " +
            item.price
        );
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(101, "Pen", 50, 10.0);
        inventory.addAtEnd(102, "Notebook", 20, 50.0);
        inventory.addAtBeginning(103, "Pencil", 100, 5.0);

        inventory.displayInventory();

        inventory.updateQuantity(101, 60);
        inventory.searchByName("Notebook");

        inventory.totalInventoryValue();

        inventory.sort("price", true);
        inventory.displayInventory();
    }
}

