public enum ProductQuality implements ProductState{
    NORMAL(1.2), LITLLE_SPOILED(0.95), HALF_SPOILED(0.55), MOSTLY_SPOILED(0.25), ALLSPOILED(0.1);
    private final double lastPrice;
    private ProductQuality(double lastPrice) {
        this.lastPrice = lastPrice;
    }
    @Override
    public double getPrice(){
        return lastPrice;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
