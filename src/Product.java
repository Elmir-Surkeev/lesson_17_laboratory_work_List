import java.util.Objects;

public class Product {
    private String name;
    private double weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(weight, product.weight) == 0 && Double.compare(price, product.price) == 0 && exclusive == product.exclusive && Objects.equals(name, product.name) && quality == product.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price, quality, exclusive);
    }

    private double price;
    private ProductQuality quality;
    private boolean  exclusive;

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public ProductQuality getQuality() {
        return quality;
    }

    public void setQuality(ProductQuality quality) {
        this.quality = quality;
    }

    public Product(String name, double price, double weight, ProductQuality quality, boolean exclusive) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quality = quality;
        this.exclusive = exclusive;
    }
    public void degradeQuality() {
        ProductQuality[] qualities = ProductQuality.values();
        int currentIndex = quality.ordinal();
        if (currentIndex < qualities.length - 1) {
            this.quality = qualities[currentIndex + 1];
        }
    }

    public double getSalePrice() {
        return price * quality.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
