class MarinadeFishBuilder extends DishBuilder {
    @Override
    Dish getResult() {
        prepareIngredients();
        cookIngredientsToDish();
        System.out.println("MarinadeFish is ready");
        return dish;
    }

    @Override
    void prepareIngredients() {
        dish = new MarinadeFish();
        System.out.println("Prepare plate for marinadeFish");

        dish.ingredients.add(Ingredient.FISH);
        dish.ingredients.add(Ingredient.SAUCE);
        System.out.println("Get ingredients for marinadeFish");
    }


}
