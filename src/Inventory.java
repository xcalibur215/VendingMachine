import java.util.ArrayList;
import java.util.Map;

public class Inventory {
    private ArrayList<Item> stock;

    public Inventory() {
        this.stock = new ArrayList<>();
        stock.add(new Item("Cola", 1.2, "Drink", 20));
        stock.add(new Item("Pepsi", 1.0, "Drink", 20));
        stock.add(new Item("Latasoy", 1.5, "Drink", 20));
        stock.add(new Item("Water(250ml)", 1.0, "Drink", 20));
        stock.add(new Item("Chips", 2.5, "Snack", 20));
        stock.add(new Item("Jelly", 0.5, "Snack", 20));
        stock.add(new Item("Chocolate", 0.8, "Snack", 20));
        stock.add(new Item("Egg Fried Rice", 4.0, "Meal", 20));
        stock.add(new Item("Sphagetti", 3.0, "Meal", 20));
        stock.add(new Item("Fried Chicken", 5.0, "Meal", 20));
    }

    void addItem(Item item) {
        this.stock.add(item);
    }

    void removeItem(Item item) {
        this.stock.remove(item);
    }
    public void displayInventory() {
        int counter = 1;
        for (Item item : stock) {
            System.out.printf("%2d: %-25s - $%4.2f  (stock: %3d)\n", counter, item.getName(), item.getPrice(),item.getQuantity());
            counter++;
        }
    }

    public String getItemName(int index) {
        return stock.get(index).getName();
    }

    public Item getItem(int index) {
        return stock.get(index);
    }

    public int getItemStock(int index) {
        return stock.get(index).getQuantity();
    }

    public void afterSaleUpdate(Map<Item, Integer> cartDict) {
        for (Map.Entry<Item, Integer> entry : cartDict.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            item.decreaseQuantity(quantity);
        }
    }
}