import java.util.ArrayList;
import java.util.List;

public class Truck {
    private int maxWeight;
    private int speed;
    private List<Product> productList;
    private int totalWeight;

    public Truck(int maxWeight){
        this.maxWeight = maxWeight;
        this.speed = 5;
        this.productList = new ArrayList<Product>();
        this.totalWeight = 0;
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
}
