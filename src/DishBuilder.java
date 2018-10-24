import java.util.ArrayList;

public abstract class DishBuilder {



Dish dish;
    abstract Dish getResult();
    abstract void prepareIngredients();
    void cookIngredientsToDish() {
        for (Enum ingredient:dish.ingredients
        ) {
            System.out.println("Cook "+ingredient);
        }
    }
}


