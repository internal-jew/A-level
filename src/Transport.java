import java.util.Date;
import java.util.Objects;

public abstract class Transport {
    private final String model;
    private final int productionYear;
    private int capacity;
    private int maxWeight;

    private int shelfLife;

    public Transport(String model, int productionYear, int capacity, int maxWeight, int shelfLife) {
        this.model = model;
        this.productionYear = productionYear;
        this.capacity = capacity;
        this.maxWeight = maxWeight;
        this.shelfLife = shelfLife;

    }

    public abstract void move();

    @Override
    public boolean equals(Object o) {
        System.out.println("Override method equals in class Transport");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return productionYear == transport.productionYear &&
                capacity == transport.capacity &&
                maxWeight == transport.maxWeight &&
                shelfLife == transport.shelfLife &&
                Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        System.out.println("Override method hashCode in class Transport");
        return Objects.hash(model, productionYear, capacity, maxWeight, shelfLife);
    }
}
