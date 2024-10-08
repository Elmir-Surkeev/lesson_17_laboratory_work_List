import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class City {
    private Event event;
    private CityEnum cityEnum;
    private int distance;
    private Map<CityEnum, Integer> allCities = new HashMap<>();
    Random random = new Random();

    public City() {
        this.distance = random.nextInt(50) + 50; // Генерация дистанции от 50 до 100
        populateCities();

    }

    private void populateCities() {
        for (CityEnum city : CityEnum.values()) {
            allCities.put(city, new Random().nextInt(50) + 50); // Дистанция от 50 до 100
        }
    }

    public void randomCity() {
        int cities = random.nextInt((5) + allCities.size());
        int allDistance = 0;
        for (int i = 0; i< allCities.size(); i++){
            Object[] citiesArray = allCities.keySet().toArray();
            CityEnum randomCity = (CityEnum) citiesArray[new Random().nextInt(citiesArray.length)];
            int cityDistance = allCities.get(randomCity);
            allDistance+=cityDistance;
            System.out.println("Выбран город: " + randomCity + ", дистанция: " + cityDistance);
        }
        System.out.println("Общее расстояние " + allDistance);

    }

    public int getDistance() {
        return distance;
    }
}

