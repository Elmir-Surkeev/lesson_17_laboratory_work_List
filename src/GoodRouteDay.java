public class GoodRouteDay implements Eventable {
    @Override
    public void apply(Truck truck) {
        System.out.println("Сегодня ровная дорога, поехали быстрее");
        if (truck.getSpeed()<10){
            truck.setSpeed(truck.getSpeed()+2);
        }
    }
}
