import java.util.Date;

public abstract class Transport {
    final String model;
    private final int productionYear;
    private int capacity;
    private int maxWeight;

    private int shelfLife;

    public Transport(String model, int productionYear, int capacity, int maxWeight, int shelfLife) {
        this.model = model;
        this.productionYear=productionYear;
        this.capacity=capacity;
        this.maxWeight=maxWeight;
        this.shelfLife=shelfLife;

    }
}
