import java.util.List;
import java.util.Random;

// Событие "Обычный день", ничего не происходит.
public class NormalDay implements Eventable {
    @Override
    public void apply(Truck truck) {
        System.out.println("Обычный день — ничего не произошло.");
    }
}
