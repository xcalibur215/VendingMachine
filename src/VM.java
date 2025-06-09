public class VM {
    Inventory inventory;

    public VM(){
        this.inventory = new Inventory();
    }

    public void showMenu(){
        inventory.displayInventory();
    }

    public double rechargeCoin(double initialAmount, double coin){
        if (coin == 0.25 || coin == 0.50 || coin == 1){
            initialAmount += coin;
        }
        return initialAmount;
    }

    public void purchase(double amount){

    }
    public void purchase(Item item, double amount, Personnel member){

    }

}