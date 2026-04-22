public class Products {
    // 1. Variables
    private int id;
    private String name;
    private double price;

    // 2. Constructor
    public Products(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 3. Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
