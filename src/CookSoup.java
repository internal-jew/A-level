public class CookSoup implements DishFactory {
    @Override
    public Dish makeDish() {
        DishBuilder seafoodSoupBuilder = new SeafoodSoupBuilder();
        return seafoodSoupBuilder.getResult();
    }
}
