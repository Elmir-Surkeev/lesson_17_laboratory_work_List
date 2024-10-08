import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Action {
    public static void start() {

        List<City> cities = List.of(
                new City("Osh"),
                new City("Jalal-Abad"),
                new City("Kara-Kol"),
                new City("Kara-Balta"),
                new City("Bishkek"),
                new City("Tokmok")
        );

        List<Product> productList = List.of(
                new Product("Meat", 100, 10, ProductQuality.NORMAL, false),
                new Product("Сухофрукты", 50, 5, ProductQuality.NORMAL, false),
                new Product("Зерно", 80, 7, ProductQuality.NORMAL, true),
                new Product("Мука", 200, 10, ProductQuality.NORMAL, false),
                new Product("Ткань", 100, 10, ProductQuality.NORMAL, false),
                new Product("Краска", 200, 5, ProductQuality.NORMAL, false)
        );

        Truck truck = new Truck(400);
        Merchant merchant = new Merchant(2000, truck);

        merchant.buyProduct(productList);
        Random rnd = new Random();

        int days = 5 + rnd.nextInt(cities.size()-3);
        System.out.println("Наш путь заимет : "+ days);
        int allDistance = 0;
        City city;
        for (int i = 0; i < days; i++) {
            //тут возник вопрос как именно рабоает .get(если я верно понял по индексам да)
            city = cities.get(rnd.nextInt(cities.size()));
            Eventable event = EventGenerator.getRandomEvent();
            if (event instanceof MarketTalk){
                allDistance+=allDistance/4;
                allDistance+= city.getDistance()*3/2;
            }
            if (event instanceof BrokenWheelDay || event instanceof RiverDay) {
                days++;
                System.out.println("Произошла поломка колеса, день " + (i + 1) + " пропущен.");
                System.out.println("Плюс день к дате: " + days + " дней");
                continue;
            }
            allDistance += city.getDistance();
            event.apply(merchant.getTruck(), merchant);
            System.out.println("|Пройден " + (i + 1) + " день | расстояние до города :" + city.getDistance());
        }

        System.out.println("Торговец прибыл.");
        System.out.println("Пройденное расстояние: " + allDistance + " км");


        double totalSale = 0;
        for (Product item : merchant.getTruck().getProductList()) {
            totalSale += item.getSalePrice();
        }


        double initialMoney = 2000;
        System.out.println("Товары проданы на сумму: " + totalSale);
        System.out.println("Прибыль: " + (totalSale - (initialMoney - merchant.getMoney())));
    }
}
