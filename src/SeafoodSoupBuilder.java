public class SeafoodSoupBuilder extends DishBuilder {



    @Override
    Dish getResult() {
        prepareIngredients();
        cookIngredientsToDish();
        return dish;
    }

    @Override
   void prepareIngredients() {
        dish=new SeafoodSoup();
        dish.ingredients.add(Ingredient.MOLLUSKS);
        dish.ingredients.add(Ingredient.CRAB);
        dish.ingredients.add(Ingredient.WATER);
        dish.ingredients.add(Ingredient.SALT);
    }

}
