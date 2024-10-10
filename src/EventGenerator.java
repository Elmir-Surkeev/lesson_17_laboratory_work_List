import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    private static final List<Eventable> INITIAL_EVENTS = List.of(new NormalDay(),
            new RainDay(), new GoodRouteDay(), new BrokenWheelDay(),
            new RiverDay(), new MeetResidentDay(), new MeetRobberBigRouteDay(),
            new MarketTalk());

    private static final List<Eventable> EVENTS = new ArrayList<>(INITIAL_EVENTS);

    private static boolean isMarketTalkUsed = false;

    public static Eventable getRandomEvent() {
        Random random = new Random();

        if (!isMarketTalkUsed) {
            for (Eventable event : EVENTS) {
                if (event instanceof MarketTalk) {
                    isMarketTalkUsed = true;
                    EVENTS.remove(event);
                    break;
                }
            }
        }
        return EVENTS.get(random.nextInt(EVENTS.size()));
    }
}
