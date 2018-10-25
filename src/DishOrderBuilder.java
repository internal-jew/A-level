import java.util.Arrays;
import java.util.Scanner;

public class DishOrderBuilder implements OrderBuilder {
    private Order order;
    private int countOfDishes = 1;

    public void createNewOrder() {
        this.order = new Order();
    }

    public void takeMenu() {
        order.menuList.addAll(Arrays.asList(DishName.values()));
    }


    public void offerMenu() {

        System.out.println("Welcome to restaurant.");
        System.out.println("-----------------------");
        System.out.println("Please make an order:");
        for (Enum dishName : order.menuList
        ) {
            System.out.println(countOfDishes++ + " " + dishName);
        }
        System.out.println("0. End order");
    }

    public void askClientAboutChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of your choice:");
        do {
            int numberOfChoice = scanner.nextInt();
            if (numberOfChoice == 0) {
                if (order.orderList.size() > 0) {
                    return;
                } else {
                    System.out.println("You may choose anything");
                }
            } else if (numberOfChoice > 0 && numberOfChoice < countOfDishes) {
                order.orderList.add(order.menuList.get(numberOfChoice - 1));
                System.out.println("Great choice. Anything else?");
            } else {
                System.out.println("Your entered number is absent in menu. Please try again");
            }

        }
        while (true);
    }


    public Order getOrder() {
        createNewOrder();
        takeMenu();
        offerMenu();
        askClientAboutChoice();
        return order;
    }


}
