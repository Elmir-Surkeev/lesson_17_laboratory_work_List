import java.util.Random;

public class City {
    private String name;
    private int distance;

    public City(String name) {
        this.name = name;
        this.distance = 1;
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