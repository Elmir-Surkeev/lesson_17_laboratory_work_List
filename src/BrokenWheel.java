public class BrokenWheel implements Eventable{
    @Override
    public void apply(Truck truck) {
        System.out.println("Сломалось колесо день потратился впустую");
    }
}
