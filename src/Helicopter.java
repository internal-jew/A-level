import java.util.Date;

public class Helicopter extends AirTransport {


    public Helicopter(String model, int productionYear){
        super(model,productionYear,0,0,0);
    }

public void move(){
        fly();
        landing();
}


    @Override
    public void fly() {
        startEngine();
        goToSky();
    }

    @Override
    public void landing() {
        verticalDecline();
        System.out.println("Helicopter is landed");
    }

    private void startEngine() {
        System.out.println("Start engine in helicopter");
    }


    private void goToSky() {
        System.out.println("Helicopter is flying");
    }
    private void verticalDecline() {
        System.out.println("Helicopter is vertical declining");
    }


}
