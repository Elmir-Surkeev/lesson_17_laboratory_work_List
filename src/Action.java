public class Action {
    public static void start() {
        onBaseState s = new onBaseState();
        try {
            s.getCredit();
            s.buyProduct();
            s.startRoute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
