public class BrokenWheelDay implements Eventable{
    @Override
    public void apply(Truck truck, Merchant merchant) {
        System.out.println("Сломалось колесо день потратился впустую");
    }
}
