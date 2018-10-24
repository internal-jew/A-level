public class DirectorOfDishBuilders {
    DishBuilder dishBuilder;


    DirectorOfDishBuilders(DishBuilder dishBuilder) {
        this.dishBuilder = dishBuilder;
    }


    public void changeBuilder(DishBuilder dishBuilder) {
        this.dishBuilder = dishBuilder;
    }

    public Dish makeDish() {
        dishBuilder.prepareIngredients();
        dishBuilder.cookIngredientsToDish();
        return dishBuilder.getResult();
    }
}
