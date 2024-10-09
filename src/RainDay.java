import java.util.List;
import java.util.Random;

public class RainDay implements Eventable {
    @Override
    public void apply(Truck truck) {
        System.out.println("Дождь! Скорость телеги уменьшена.");
        truck.setSpeed(truck.getSpeed() - 2);

        Random random = new Random();
        if (random.nextDouble() < 0.3) {
            List<Product> items = truck.getProductList();
            if (!items.isEmpty()) {
                Product item = items.get(random.nextInt(items.size()));
                //item.degradeQuality(); // Понизить качество товара.
                System.out.println("Товар " + item.getName() + " испортился.");
            }
        }
    }
}
