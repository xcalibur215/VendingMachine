import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> stock;

    public Inventory() {
        this.stock = new ArrayList<>();
        stock.add(new Item("Cola",1.2,"Drink"));
        stock.add(new Item("Pepsi",1.0,"Drink"));
        stock.add(new Item("Latasoy",1.5,"Drink"));
        stock.add(new Item("Water(250ml)",1.0,"Drink"));
        stock.add(new Item("Chips",2.5,"Snack"));
        stock.add(new Item("Jelly",0.5,"Snack"));
        stock.add(new Item("Chocolate",0.8,"Snack"));
        stock.add(new Item("Egg Fried Rice",4.0,"Meal"));
        stock.add(new Item("Spjagetti",3.0,"Meal"));
        stock.add(new Item("Fried Chicken Tendons",5.0,"Meal"));
    }

    void addItem(Item item){
        this.stock.add(item);
    }

    void removeItem(Item item){
        this.stock.remove(item);
    }

    void getTotalValue(){
        double totalprice = 0;
        for (Item item: stock){
            totalprice += item.getPrice();
        }
    }
    public int getItemTotal(){
        return this.stock.size();
    }

    public void displayInventory(){
        int counter = 1;
        for (Item item: stock){
            System.out.printf("%2d: %-25s - %4.2f\n",counter,item.getName(),item.getPrice());
            counter++;
        }

    }
}
