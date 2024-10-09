import java.util.List;
import java.util.Random;

public class Merchant {
   private double money;
   private Truck truck;

   public Merchant(double money, Truck truck) {
       this.money = money;
       this.truck = truck;
   }
   public void buyProduct(List<Product>boughtProducts) {
        Random rnd = new Random();
        while (money > 0){
            Product product = boughtProducts.get(rnd.nextInt(boughtProducts.size()));
            if(truck.addProduct(product) && money >= product.getPrice()){
                money -= product.getPrice();
                System.out.println("Товар : "+product.getName() + " куплен за: " + product.getPrice());
            }else {
                break;
            }
        }
   }
    public void travel(City destination) {
        System.out.println("Начинаем путь в " + destination.getName() + " (расстояние: " + destination.getDistance() + " лиг)");
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Truck getTruck() {
        return truck;
    }

    @Override
    public String toString() {
        return "Торговец (деньги: " + money + ")";
    }
}
