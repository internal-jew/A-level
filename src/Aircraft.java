import java.util.Date;

public class Aircraft extends AirTransport {


    public Aircraft(String model, int productionYear) {
        super(model, productionYear);

    }

    @Override
    public void fly() {
        startEngine();
        goToRunway();
        goToSky();
    }

    @Override
    public void landing() {
        searchingLandingField();
        gradualDecline();
        System.out.println("Aircraft is landed");
    }

    private void startEngine() {
        System.out.println("Start engine in aircraft");
    }

    private void goToRunway() {
        System.out.println("Aircraft goes to the runway");
    }

    private void goToSky() {
        System.out.println("Aircraft is flying");
    }

    private void searchingLandingField() {
        System.out.println("Aircraft is searching for landing field");
    }

    private void gradualDecline() {
        System.out.println("Aircraft is starting gradual declining");
    }


}
