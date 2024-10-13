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
        int priceRobber = 5;
        if (merchant.getMoney() > 0 && merchant.getMoney() > priceRobber){
            merchant.setMoney(merchant.getMoney() - priceRobber);
            System.out.println("Грабитель забрал "+priceRobber+" монет");
            System.out.println("У продавца осталось: " + merchant.getMoney());
        }else{
           Product mostExpensiveProduct = merchant.getTruck().getMostExpensiveProduct();
           if (mostExpensiveProduct != null){
               merchant.getTruck().getProductList().remove(mostExpensiveProduct);
               System.out.println("Грабитель забрал самый дорогой  " + mostExpensiveProduct.getName());
           }else {
               System.out.println("Грабитель не стал красть у вас товар, точнее не нашел у вас null");
           }
        }
    }
}
