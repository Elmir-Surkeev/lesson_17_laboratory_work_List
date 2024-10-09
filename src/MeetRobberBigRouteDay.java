public class MeetRobberBigRouteDay implements Eventable{
    @Override
    public void apply(Truck truck, Merchant merchant) {
        applyMerchant(merchant);
    }
    public void applyMerchant(Merchant merchant) {
        System.out.println("Продавец встретил грабителя, Он должен быть на чеку");
        checkMoney(merchant);
    }
    public void checkMoney(Merchant merchant) {
        if (merchant.getMoney() > 0){
            merchant.setMoney(merchant.getMoney() - 100);
            System.out.println("Грабитель забрал 100 монет");
        }else{
           Product mostExpensiveProduct = merchant.getTruck().getMostExpensiveProduct();
           if (mostExpensiveProduct != null){
               merchant.getTruck().getProductList().remove(mostExpensiveProduct);
               System.out.println("Грабитель забрал самый дорогой товар" + mostExpensiveProduct.getName());
           }else {
               System.out.println("Грабитель не стал красть у вас товар, точнее не нашел у вас null");
           }
        }
    }
}
