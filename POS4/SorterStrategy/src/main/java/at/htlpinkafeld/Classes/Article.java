package at.htlpinkafeld.Classes;

public class Article{
    private String name;
    private double price;
    private Category category;

    public enum Category {
        FOOD, OTHER;

        // method returns the tax rate
        public double getTaxRate() {
            return switch (this) {
                case FOOD -> 0.10;
                case OTHER -> 0.20;
            };
        }
    }

    public Article(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getTax() {
        return price * category.getTaxRate();
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", tax=" + getTax() +
                '}';
    }
}
