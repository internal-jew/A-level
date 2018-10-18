import java.util.Date;

public abstract class AirTransport extends Transport {

    public AirTransport(String model, int productionYear, int capacity, int maxWeight, int shelfLife) {
        super(model, productionYear, capacity, maxWeight, shelfLife);
    }

    public AirTransport(String model, int productionYear) {
        super(model, productionYear, 0, 0, 0);
    }


    public abstract void fly();

    public abstract void landing();
}
