import java.util.Random;

public class City {
    private String name;
    private int distance;

    public City(String name) {
        this.name = name;
        Random rnd = new Random();
        this.distance = 50 + rnd.nextInt(51);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}