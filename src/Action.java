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

        int days = 5 + rnd.nextInt(cities.size() - 3);
        int totalDistance = 100;
        int traveledDistance = 0;

        System.out.println("Наш путь займёт: N количество дней и " + totalDistance + " клеток");

        City city;
        for (int i = 0; i < 150; i++) {
            if (traveledDistance >= totalDistance) {
                System.out.println("Вы прошли все " + totalDistance + " клеток.");
                break;
            }

            city = cities.get(rnd.nextInt(cities.size()));
            Eventable event = EventGenerator.getRandomEvent();

            if (event instanceof MarketTalk) {
                int reducedDistance = traveledDistance / 4;
                traveledDistance += traveledDistance/4;
                System.out.println("MarketTalk: путь увеличен на " + reducedDistance + " клеток.");
            }

            if (event instanceof MeetResidentDay) {
                int extraDistance = 3;
                traveledDistance += extraDistance;
                System.out.println("|Пройден " + (i + 1) + " день | пройдено 3 клетки.");
            }

            if (event instanceof BrokenWheelDay || event instanceof RiverDay) {
                days++;
                System.out.println("Произошла поломка колеса, день " + (i + 1) + " пропущен.");
                System.out.println("Продолжительность пути увеличена на 1 день, теперь: " + days + " дней.");
                continue;
            }

            traveledDistance += city.getDistance();
            event.apply(merchant.getTruck(), merchant);
            System.out.println("|Пройден " + (i + 1) + " день | расстояние до города: " + city.getDistance() + " клеток");

            if (traveledDistance > totalDistance) {
                    for (int f = 0; f > 10; f++){
                        if (totalDistance == traveledDistance){
                            traveledDistance-=1;
                            if (traveledDistance == totalDistance){
                                System.out.println("Вы достигли конечной цели.");
                                break;
                            }
                        }
                }
                break;
            }
        }

        System.out.println("Торговец прибыл.");
        System.out.println("Пройденное расстояние: " + traveledDistance + " клеток");

        double totalSale = 0;
        for (Product item : merchant.getTruck().getProductList()) {
            totalSale += item.getSalePrice();
        }

        double initialMoney = 2000;
        System.out.println("Товары проданы на сумму: " + totalSale);
        double money = (totalSale - (initialMoney - merchant.getMoney()));
        if (money > 0){
            System.out.println("Прибыль: " + money);
        }else {
            System.out.println("Убыток: "+ money);
        }
    }
}
