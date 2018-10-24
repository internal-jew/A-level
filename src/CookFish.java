public class CookFish extends DishFactory {
    @Override
    public Dish makeDish() {
        return new MarinadeFish();
    }
}
