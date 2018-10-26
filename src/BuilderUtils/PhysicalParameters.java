package BuilderUtils;

public class PhysicalParameters {
   private double lenght;
   private double width;
   private double thickness;

    public PhysicalParameters(double lenght, double width, double thickness) {
        this.lenght = lenght;
        this.width = width;
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "{" +
                "lenght=" + lenght +
                ", width=" + width +
                ", thickness=" + thickness +
                '}';
    }
}
