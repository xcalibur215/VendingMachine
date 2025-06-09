public abstract class Personnel {
    private String name;
    private String rank;
    private double balance;

    public Personnel(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void getMemberinfo(){
    }
    abstract double getDiscountRate();
}