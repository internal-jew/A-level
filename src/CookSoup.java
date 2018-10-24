public class CookSoup extends DishFactory {
    @Override
    public Dish makeDish() {
       DishBuilder seafoodSoupBuilder=new SeafoodSoupBuilder();
        return seafoodSoupBuilder.getResult();
    }
}
