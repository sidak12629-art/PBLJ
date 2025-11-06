public class Product {
    private String category;
    private String name;
    private double price;

    public Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() { return category; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s (%s) - %.2f", name, category, price);
    }
}
