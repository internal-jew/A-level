public class CookFish implements DishFactory {
    @Override
    public Dish makeDish() {
        DishBuilder marinadeFishBuilder = new MarinadeFishBuilder();
        return marinadeFishBuilder.getResult();

    }
}
