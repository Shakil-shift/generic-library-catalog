import java.util.HashMap;
import java.util.Map;

public class Catalog<T> {
    private final Map<String, LibraryItem<T>> items = new HashMap<>();

    public void addItem(LibraryItem<T> item) {
        if (items.containsKey(item.getItemID())) {
            throw new IllegalArgumentException(
                "Item with ID " + item.getItemID() + " already exists.");
        }
        items.put(item.getItemID(), item);
    }

    public void removeItem(String itemID) {
        if (!items.containsKey(itemID)) {
            throw new IllegalArgumentException(
                "Cannot remove: no item with ID " + itemID);
        }
        items.remove(itemID);
    }

    public LibraryItem<T> getItem(String itemID) {
        LibraryItem<T> item = items.get(itemID);
        if (item == null) {
            throw new IllegalArgumentException(
                "No item found with ID " + itemID);
        }
        return item;
    }

    public void listAll() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }
        System.out.println("=== Catalog Contents ===");
        items.values().forEach(System.out::println);
    }
}