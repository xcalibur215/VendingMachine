//Aung Kyaw Khant (ID - 6700190022)

import java.util.Scanner;
public class VendingMachine {

    private static final double COIN1 = 0.25;
    private static final double COIN2 = 0.50;
    private static final double COIN3 = 1.00;
    private static final double CHIP_PRICE = 1.50;
    private static final double SODA_PRICE = 1.00 ;
    private static final double CANDY_PRICE = 0.75 ;
    
    public static void main(String[] args) {
        boolean greeting = true;
        double coinInserted = 0;
        Scanner scanner = new Scanner(System.in);
        
        //looping the program for the vending machine
        while(greeting){
            System.out.println("Welcome");
            
            while(true){
                System.out.println("Please insert coins($0.25, $0.5, $1)!");
                double coin = scanner.nextDouble();
                
                //Handling coin insertion
                if(coin == COIN1 || coin == COIN2 || coin == COIN3){
                    coinInserted += coin;
                    System.out.println("Your balance is now: " + coinInserted);
                    
                } else {
                        System.out.println("Invalid coin. Please try again.");
                    }
                
                System.out.println("Wanna insert more coins? (y/n) ");
                if (scanner.next().equalsIgnoreCase("n")) {
                    System.out.println("**********************");
                    System.out.println("$" + coinInserted + " inserted!");
                    System.out.println("**********************");
                    break;
                }
            }
                
                //Handling menu and prompt for user choice
                /*int userChoice = 0;
                boolean choose = true;
                while(choose) {
                    System.out.println("Please choose the item below");
                    System.out.println("1. Chips    - $1.50 (instock)");
                    System.out.println("2. Soda     - $1.00 (out of stock)");
                    System.out.println("3. Candybar - $0.75 (instock)");
                    System.out.println("Please choose your item (1/2/3): ");
                    userChoice = scanner.nextInt();
                    if (userChoice <1 || userChoice > 3) {
                        System.out.println("Invalid choice of item! Please select between 1 and 3.");
                    } else {
                        choose = false;
                        return userChoice;
                    }
                } */
                
            int userChoice = getUserChoice(scanner);
            double change = 0;
            boolean valid = true;
            while (valid) {
                if (userChoice == 1) {
                    System.out.println("Chips selected. The price is $" + CHIP_PRICE + " each.");
                    System.out.println("Making sure the item is instock and money is enough....");
                    change = coinInserted - CHIP_PRICE;
                    System.out.println("Purchase successful. Dispensing the Chip and $" + change + " change.");
                    System.out.println("----------- Thanks you for purchasing -----------");
                    break;
                }
                if (userChoice == 2) {
                    System.out.println("Soda is out of stock. Please choose another item.");
                    userChoice = getUserChoice(scanner);
                    
                }
                if (userChoice == 3) {
                    System.out.println("Candybar selected. The price is $" + CANDY_PRICE + " each.");
                    System.out.println("Making sure the item is instock and money is enough....");
                    change = coinInserted - CANDY_PRICE;
                    System.out.println("Purchase successful. Dispensing the Candybar and $" + change + " change.");
                    System.out.println("----------- Thanks you for purchasing -----------");
                    break;
                }

            }
        }   
    }
    //method for validating user choice
    public static int getUserChoice(Scanner scanner){
        int userChoice = 0;
        boolean choose = true;
        while (choose){
            System.out.println("Please choose the item below");
            System.out.println("1. Chips    - $1.50 (instock)");
            System.out.println("2. Soda     - $1.00 (out of stock)");
            System.out.println("3. Candybar - $0.75 (instock)");
            System.out.println("Please choose your item (1/2/3): ");

            userChoice = scanner.nextInt();
            //ensuring user only choose from 1 to 3
            if (userChoice < 1 || userChoice > 3){
                System.out.println("Your item choice is invalid. Please choose within the 1-3 range.");
            } else {
                choose = false; /*breaking the choice confirmation loop*/
            }
        }
        return userChoice;
    }

}

