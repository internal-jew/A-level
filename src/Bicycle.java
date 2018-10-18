import java.util.Date;

public class Bicycle extends GroundTransport {

    @Override
    public void ride() {
        System.out.println("Bicycle is riding");
    }

    public Bicycle(String model, int productionYear) {
        super(model, productionYear);
    }


}
