public class Product {
    private String name;
    private double weight;
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
