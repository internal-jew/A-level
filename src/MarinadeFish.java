public class MarinadeFish implements Dish {

    MarinadeFish() {
        System.out.println("Constructor of MarinadeFish");
    }


    @Override
    public Dish createDish() {

        return new MarinadeFish();
    }
}
