public interface OrderBuilder {
    void createNewOrder();

    void offerMenu();

    void askClientAboutChoice();

    void takeMenu();

    Order getOrder();
}
