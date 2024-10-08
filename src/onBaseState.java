import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class onBaseState implements StateWeather {

    Merchant merchant = new Merchant();
    Random rnd = new Random();

    @Override
    public void buyProduct() throws Exception {
        List<Product> boughtProducts = new ArrayList<>();
        try {
            randomProducts(boughtProducts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startRoute() throws Exception {
        City city = new City();
        city.randomCity();
    }

    @Override
    public void getCredit() throws Exception {
        merchant.setSavings(merchant.getSavings() + 2000);
        System.out.println("Текущие сбережения: " + merchant.getSavings());
    }


    public void randomProducts(List<Product> boughtProducts) {
        Product meat = new Product("meat", 500, 2.4, null);
        Product driedFruits = new Product("driedFruits", 200, 0.5, null);
        Product corn = new Product("corn", 150, 10, null);
        Product flour = new Product("flour", 200, 50, null);
        Product textile = new Product("textile", 1200, 10, null);
        Product paint = new Product("paint", 1500, 5, null);

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(meat);
        allProducts.add(corn);
        allProducts.add(driedFruits);
        allProducts.add(textile);
        allProducts.add(flour);
        allProducts.add(paint);

        double currentTotalCost = 0;
        double currentTotalWeight = 0;
        int money = merchant.getSavings();
        double weightLimit = 250;

        while (currentTotalCost < money && currentTotalWeight < weightLimit) {
            Product randomProduct = allProducts.get(rnd.nextInt(allProducts.size()));
            if (currentTotalCost + randomProduct.getPrice() <= money &&
                    currentTotalWeight + randomProduct.getWeight() <= weightLimit) {
                boughtProducts.add(randomProduct);
                currentTotalCost += randomProduct.getPrice();
                currentTotalWeight += randomProduct.getWeight();
            }
        }

        for (Product product : boughtProducts) {
            System.out.println("Куплен продукт: " + product.getName() + ", цена: " + product.getPrice() + ", вес: " + product.getWeight());
        }

        System.out.println("Общая стоимость: " + currentTotalCost);
        System.out.println("Общий вес: " + currentTotalWeight);
    }
}
