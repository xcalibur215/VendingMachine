import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean buyagain = true;
        VM vm = new VM(); //outside of while loop for tracking the stock quantity
        while (buyagain) {
            vm.welcome();
            vm.showMenu();
            Cart cart = new Cart(new HashMap<>());
            boolean menuLoop = true; // loop to get the user choice of item
            while (menuLoop) {
                int choice = -1;
                // Input validation for item choice
                while (true) {
                    System.out.print("\nPlease choose the item type (1-10): ");
                    if (sc.hasNextInt()) {
                        choice = sc.nextInt();
                        if (choice >= 1 && choice <= 10) {
                            break;
                        }
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                        sc.next(); // Clear invalid input
                    }
                }
                int index = choice-1;
                int amount = -1;
                // Input validation for amount
                while (true) {
                    System.out.printf("Please choose the amount of [ %s ] to buy: ", vm.inventory.getItemName(index));
                    if (sc.hasNextInt()) {
                        amount = sc.nextInt();
                        if (amount > 0 && amount <= vm.inventory.getItemStock(index)) {
                            break;
                        } else {
                            System.out.println("Out of stock or invalid amount. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please try again.");
                        sc.next(); // Clear invalid input
                    }
                }

                // Add item to cart after validation
                cart.addToCart(vm.inventory.getItem(index), amount);
                System.out.printf("\n=> [ %s x %d ] added to cart! Want to add more items? (y/n): ", vm.inventory.getItemName(index), amount);
                String userChoice = sc.next();
                if (userChoice.equalsIgnoreCase("n")) {
                    menuLoop = false;
                }
            }

            // Proceed to checkout and payment
            double requiredMoney = cart.checkOut(sc); // Passing the scanner to avoid conflicts
            double change = vm.pay(requiredMoney, sc);
            System.out.printf("Purchase successful. Items dispensed and $%.2f change returned.\n", change);
            vm.afterSaleUpdate(cart.cartDict); //removing the sold items from inventory
            System.out.println("\nDo you want to buy more? (y/n): ");
            sc.nextLine();
            String response = sc.next();
            if (response.equalsIgnoreCase("n")) {
                buyagain = false;
            }
        }
    }
}