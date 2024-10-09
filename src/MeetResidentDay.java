import java.util.Random;

public class MeetResidentDay implements Eventable{
    @Override
    public void apply(Truck truck) {
        //добавляется нитро для передвижения по лигам
        System.out.println("Продавцу повезло, он встретил местного, который подсказал короткую дорогу");
        Random rnd = new Random();
        int nitro = rnd.nextInt((3)+6);
        truck.setSpeed(truck.getSpeed()+nitro);
    }
}
