public abstract class DishFactory {
    public abstract Dish makeDish();

    public void putDishToOrder(Dish dish){
        System.out.println(dish);
    }

}
