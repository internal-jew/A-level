import java.util.Date;

public abstract class GroundTransport extends Transport {

    public abstract void ride();

    public GroundTransport(String model, int productionYear) {
        super(model, productionYear, 0, 0, 0);
    }

}
