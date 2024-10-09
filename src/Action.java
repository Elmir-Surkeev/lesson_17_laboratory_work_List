import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Action {
    public static void start() {
        List<City> cities = List.of(new City("Osh"), new City("Jalal-Abad"),
                new City("Kara-Kol"), new City("Kara-Balta"), new City("Bishkek"), new City("Tokmok"));

        List<Product> productList = List.of(new Product("Meat", 100, 10, ProductQuality.NORMAL),
                new Product("Сухофрукты", 50, 5, ProductQuality.NORMAL),
                new Product("Зерно", 80, 7, ProductQuality.NORMAL),
                new Product("Мука", 200, 10, ProductQuality.NORMAL),
                new Product("Ткань", 100, 10, ProductQuality.NORMAL),
                new Product("Краска", 200, 5, ProductQuality.NORMAL)
        );
        Truck truck = new Truck(400);
        Merchant merchant = new Merchant(2000, truck);
        merchant.buyProduct(productList);

        Random rnd = new Random();
        City distance = cities.get(rnd.nextInt(cities.size()));

        for (int i = 0; i < distance.getDistance(); i++) {
            Eventable event = EventGenerator.getRandomEvent();
            event.apply(merchant.getTruck());
            System.out.println("Пройдено " + (i + 1) + " лиг.");
        }

        System.out.println("Торговец прибыл в " + distance.getName());

        double totalSale = 0;
        for (Product item : merchant.getTruck().getProductList()) {
            totalSale += item.getSalePrice();
        }

        System.out.println("Товары проданы на сумму: " + totalSale);
        System.out.println("Прибыль: " + (totalSale - (500 - merchant.getMoney())));
    }
}
