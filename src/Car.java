import java.util.Date;

public class Car extends GroundTransport {
    @Override

    public void move() {
        ride();
    }

    public void ride() {
        startEngine();
        System.out.println("Car is riding");
    }

    public Car(String model, int productionYear) {
        super(model, productionYear);
    }

    private void startEngine() {
        System.out.println("Car is starting engine");
    }
}
