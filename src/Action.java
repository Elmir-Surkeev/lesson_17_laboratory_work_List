public class Action {
    public static void start() {
        onBaseState s = new onBaseState();
        try {
            s.getCredit();
            s.buyProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
