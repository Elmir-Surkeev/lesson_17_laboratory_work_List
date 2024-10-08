import java.util.Random;

public class City {
    private Event event;
    private State state;
    private CityEnum cityEnum;
    public City(Event event, State state) {
        this.event = event;
    }
    public void randomCity(CityEnum cityEnum){
        Random rnd = new Random(7);


    }
}
