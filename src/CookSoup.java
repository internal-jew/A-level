public class CookSoup  extends DishFactory{
    @Override
    public Dish makeDish() {
        return new SeafoodSoup();
    }
}
