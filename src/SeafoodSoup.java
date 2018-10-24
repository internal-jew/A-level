public class SeafoodSoup implements Dish {

    SeafoodSoup(){
        System.out.println("Constructor of SeafoodSoup");
    }

    @Override
    public Dish createDish() {
        return new SeafoodSoup();
    }
}
