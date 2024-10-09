import java.util.List;
import java.util.Random;

public class EventGenerator {
    private static final List<Eventable> EVENTS = List.of(new NormalDay(), new RainDay(), new GoodRouteDay(), new BrokenWheel(), new RiverDay(), new MeetResidentDay());

    public static Eventable getRandomEvent() {
        Random random = new Random();
        return EVENTS.get(random.nextInt(EVENTS.size()));
    }
}
