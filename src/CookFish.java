public class CookFish extends DishFactory {
    @Override
    public Dish makeDish() {
       DishBuilder marinadeFishBuilder=new MarinadeFishBuilder();
        // Dish marinadeFish=new MarinadeFish();
        return marinadeFishBuilder.getResult();

    }
}
