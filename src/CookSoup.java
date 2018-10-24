public class CookSoup  extends DishFactory{
    @Override
    public Dish makeDish() {
        SeafoodSoup seafoodSoup=new SeafoodSoup();
        return seafoodSoup.createDish();
    }
}
