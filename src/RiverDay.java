public class RiverDay implements Eventable{
    @Override
    public void apply(Truck truck, Merchant merchant) {
        System.out.println("Продавец потратил целый день пока искал брод");
    }
}
