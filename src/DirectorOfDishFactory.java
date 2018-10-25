import java.util.ArrayList;

class DirectorOfDishFactory {

    private DishFactory dishFactory;
    private ArrayList<Dish> cookedDishList;


    private void createNewCookedDishList() {
        cookedDishList = new ArrayList<>();
    }

    private void cooking(Order order) {

        for (Enum dishName : order.orderList
        ) {

            switch (String.valueOf(dishName)) {
                case "MARINADEFISH":

                    dishFactory = new CookFish();
                    break;


                //order.add(cookFish.makeDish());

                //order.add(cookSoup.makeDish());


                case "SEAFOODSOUP":
                    dishFactory = new CookSoup();
                    break;


            }

            cookedDishList.add(dishFactory.makeDish());


        }

    }


    ArrayList<Dish> getCookedDishes(Order order) {
        System.out.println("Order hit the kitchen");
        createNewCookedDishList();
        cooking(order);
        System.out.println("Order completed");
        return cookedDishList;
    }
}
