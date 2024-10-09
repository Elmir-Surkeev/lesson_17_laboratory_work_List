import java.util.Random;

public class Merchant {
    private int weightLimit = 250;
    private int travelSpeed;
    private int savings = 2000;
    private Product product;

    Random rnd = new Random();
    public void randomTravelSpeed(){
        this.travelSpeed = rnd.nextInt((1)+5);
        System.out.println(travelSpeed);
    }


    public int getTravelSpeed() {
        return travelSpeed;
    }

    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }
}
