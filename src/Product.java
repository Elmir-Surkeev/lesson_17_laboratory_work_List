public class Product {
    private String name;
    private double price;
    private double weight;
    private State state;

//    public void setProductState(){
//        switch (this.state){

    public Product(String name, double price, double weight, State state) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.state = state;
    }
//            case GOOD -> this.state = new State();
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
