import java.util.Random;

public class MeetResidentDay implements Eventable{
    @Override
    public void apply(Truck truck, Merchant merchant) {
        //добавляется нитро для передвижения по лигам
        System.out.println("Продавцу повезло, он встретил местного, который подсказал короткую дорогу");
        System.out.println("Продавцу удалось срезать 3 клетки");
        //int nitro = 3;
        //truck.setSpeed(truck.getSpeed()+nitro);
    }
}
