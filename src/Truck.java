import java.util.ArrayList;
import java.util.List;

public class Truck {
    private int maxWeight;
    private int speed;
    private List<Product> productList;
    private int totalWeight;
    private City city;

    public Truck(int maxWeight){
        this.maxWeight = maxWeight;
        this.speed = 5;
        this.productList = new ArrayList<Product>();
        this.totalWeight = 0;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    public Product getMostExpensiveProduct(){
        Product mostExpensiveProduct = null;
        for (Product product : productList){
            if (mostExpensiveProduct == null|| product.getPrice() > mostExpensiveProduct.getPrice()){
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public boolean addProduct(Product product){
        if(totalWeight + product.getWeight() <= maxWeight){
            productList.add(product);
            totalWeight += product.getWeight();
            return true;
        }else {
            return false;
        }
    }

    public void remove(Product productToSell) {
        if (productList.remove(productToSell)) {
            totalWeight -= productToSell.getWeight();
            System.out.println("Товар " + productToSell.getName() + " был успешно удален из телеги.");
        } else {
            System.out.println("Товар " + productToSell.getName() + " не найден в телеге.");
        }
    }

}
