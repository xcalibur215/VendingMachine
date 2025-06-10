import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Cart {
    Map<Item, Integer> cartDict;

    public Cart(Map<Item, Integer> cartDict) {
        this.cartDict = cartDict;
    }

    public void addToCart(Item item, int quantity) {
        if (!cartDict.containsKey(item)) {
            cartDict.put(item, quantity);
        } else {
            cartDict.put(item, cartDict.get(item) + quantity);
        }
    }

    public void viewCart() {
        System.out.println("\n  Your cart now contains: ");
        System.out.println("\n    Item                Price      Amount       Subtotal");
        System.out.println("------------------------------------------------------------");

        double GrandTotal = 0;
        for (Map.Entry<Item, Integer> entry : cartDict.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            double subtotal = item.getPrice() * quantity;
            System.out.printf(" - %-20s $%.2f      x%3d%8s %5.2f\n", item.getName(),item.getPrice(), quantity, "$", subtotal);
            GrandTotal += subtotal; // total after showing the slip
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%44s: $ %.2f\n","GrandTotal",GrandTotal);
    }

    public double checkOut(Scanner sc) {
        viewCart();
        System.out.print("\n  Would you like to proceed?(y/n): ");
        double total = 0;
        String response = sc.next(); // Changed from nextLine() to next()
        if (response.equalsIgnoreCase("y")) {
            for (Map.Entry<Item, Integer> entry : cartDict.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                total += item.getPrice() * quantity;
            }
        }
        return total;
    }
}
