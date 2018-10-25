import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dish> cookedDishes;

        OrderBuilder waiter = new DishOrderBuilder();
        Order order = waiter.getOrder();

        DirectorOfDishFactory chiefCook = new DirectorOfDishFactory();
        cookedDishes = chiefCook.getCookedDishes(order);
        System.out.println("Enjoy your meal" + cookedDishes);
    }
}
