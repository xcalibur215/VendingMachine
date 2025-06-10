public class Item {
    private String name;
    private double price;
    private String type;
    private int quantity;

    public Item(String name, double price, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
