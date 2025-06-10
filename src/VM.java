import java.util.Map;
import java.util.Scanner;

public class VM {
    Inventory inventory;

    public VM(){
        this.inventory = new Inventory();
    }

    public void welcome(){
        System.out.println("\n ***** Welcome to the Vending Machine *****");
        System.out.println("    This is the currently available menu:\n");
    }
    public void showMenu(){
        inventory.displayInventory();
    }
    public double pay(double amount, Scanner sc){
        double change = 0;
        double balance = 0;
        System.out.printf("\nYou need to pay $%.2f for the purchase.\n ", amount);
        //money insertion loop here
        while (balance < amount){
            System.out.print("  Please insert your money ($0.5, $1, $5): ");
            if (sc.hasNextDouble()) {
                double coin = sc.nextDouble();
                if (coin == 0.5 || coin == 1 || coin == 5){
                    balance += coin;
                    System.out.printf(" => $%.2f inserted. Total balance: $%.2f.\n", coin, balance);
                }
            } else {
                System.out.println("Invalid coin. Please try again.");
                sc.next();
            }
        }
        change = balance - amount;
        return change;
    }
    public void afterSaleUpdate(Map<Item, Integer> cartDict){
        inventory.afterSaleUpdate(cartDict);
    }
}