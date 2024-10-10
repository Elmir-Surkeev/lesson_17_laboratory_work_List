import java.util.List;
import java.util.Random;

public class StayTracktirDay implements Eventable {
    @Override
    public void apply(Truck truck, Merchant merchant) {
        Random rnd = new Random();
        int probability = rnd.nextInt(2);

        System.out.println("Продавец остановился в трактире, расходы ночлег и питание, он потратил 50 монет.");
        merchant.setMoney(merchant.getMoney() - 50);

        if (probability == 0) {
            List<Product> availableProducts = List.of(
                    new Product("Meat", 100, 10, ProductQuality.NORMAL, false),
                    new Product("Сухофрукты", 50, 5, ProductQuality.NORMAL, false),
                    new Product("Зерно", 80, 7, ProductQuality.NORMAL, true),
                    new Product("Мука", 200, 10, ProductQuality.NORMAL, true),
                    new Product("Ткань", 100, 10, ProductQuality.NORMAL, false),
                    new Product("Краска", 200, 5, ProductQuality.NORMAL, false)
            );

            while (merchant.getMoney() > 0) {
                Product product = availableProducts.get(rnd.nextInt(availableProducts.size()));
                if (truck.addProduct(product) && merchant.getMoney() >= product.getPrice()) {
                    merchant.setMoney(merchant.getMoney() - product.getPrice());
                    System.out.println("Товар: " + product.getName() + " куплен за: " + product.getPrice());
                } else {
                    System.out.println("Не удалось добавить товар: " + product.getName() + ". Либо недостаточно денег, либо нет места в телеге.");
                    break;
                }
            }
        } else if (probability == 1) {
            if (!truck.getProductList().isEmpty()) {
                Product productToSell = truck.getProductList().get(rnd.nextInt(truck.getProductList().size()));
                if (productToSell.isExclusive()){
                    double sellingPrice = productToSell.getPrice() * 2;
                    merchant.setMoney(merchant.getMoney() + sellingPrice);
                }
                double sellingPrice = productToSell.getPrice() * 1.2;
                merchant.setMoney(merchant.getMoney() + sellingPrice);
                truck.remove(productToSell);
                System.out.println("Товар: " + productToSell.getName() + " продан за: " + sellingPrice);
            } else {
                System.out.println("Нет товаров для продажи.");
            }
        }
    }
}
