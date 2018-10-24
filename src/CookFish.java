public class CookFish extends DishFactory {
    @Override
    public Dish makeDish() {
        MarinadeFish marinadeFish=new MarinadeFish();
        return marinadeFish.createDish();
    }
}
