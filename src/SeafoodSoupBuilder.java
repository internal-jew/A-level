class SeafoodSoupBuilder extends DishBuilder {

    @Override
    Dish getResult() {
        prepareIngredients();
        cookIngredientsToDish();
        System.out.println("SeafoodSoup is ready");
        return dish;
    }

    @Override
    void prepareIngredients() {
        dish = new SeafoodSoup();
        System.out.println("Prepare plate for seafoodSoup");
        dish.ingredients.add(Ingredient.MOLLUSKS);
        dish.ingredients.add(Ingredient.CRAB);
        dish.ingredients.add(Ingredient.WATER);
        dish.ingredients.add(Ingredient.SALT);
        System.out.println("Get ingredients for seafoodSoup");
    }

}
