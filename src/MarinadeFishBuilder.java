public class MarinadeFishBuilder extends DishBuilder {
    @Override
    Dish getResult() {
        prepareIngredients();
        cookIngredientsToDish();
        return dish;
    }

    @Override
    void prepareIngredients() {
        dish = new MarinadeFish();

        dish.ingredients.add(Ingredient.FISH);
        dish.ingredients.add(Ingredient.SAUCE);
    }


}
