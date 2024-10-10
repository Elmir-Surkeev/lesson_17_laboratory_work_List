import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarketTalk implements Eventable{
    @Override
    public void apply(Truck truck, Merchant merchant) {
       Product foundProduct = checkHaveProduct(truck, merchant);
       if (foundProduct != null && truck.getCity().getDistance() < 30) {
           startWayInMarket(truck, merchant, foundProduct);
       }
        else {
            System.out.println("У продавца в этот день не оказалось нужного товара");
        }
    }


    public Product checkHaveProduct(Truck truck, Merchant merchant) {
        Product meat = new Product("Meat", 100, 10, ProductQuality.NORMAL, false);
        if (truck.getProductList().contains(meat)){
            System.out.println("Вам повезло у вас есть такой товар");
            return meat;
        }
        return null;
    }

    public void startWayInMarket(Truck truck, Merchant merchant, Product product) {
        System.out.println("Торговец отправляется в таверну со слухами");
        List<City> cities = List.of(
                new City("Osh"),
                new City("Jalal-Abad"),
                new City("Kara-Kol"),
                new City("Kara-Balta"),
                new City("Bishkek"),
                new City("Tokmok")
        );
        Random rnd = new Random(cities.size());
        List<City>goodCity = new ArrayList<>();
        goodCity.add(cities.get(rnd.nextInt(cities.size())));

        truck.setCity(goodCity.get(rnd.nextInt(goodCity.size())));
        System.out.println("Город направления изменился "+ truck.getCity().getName());

        truck.getProductList().remove(product);
        System.out.println("Товар " + product.getName() + " был продан.");
    }

}
