public class Action {
    public static void start() {
        onBaseState s = new onBaseState();
        try {
            Merchant merchant = new Merchant();
            merchant.randomTravelSpeed();
            s.getCredit();
            s.buyProduct();
            s.startRoute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
