package hw_19.project.constants;

public enum Major {
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    COMMUNICATIONS("Communications"),
    UNDECLAREDFD("Undeclared");

    private String name;



    Major(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return  name;
    }
}