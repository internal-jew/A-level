package Enumeration;

public enum RpnHDD {

    RPN_HDD_5200("5200"),
    RPN_HDD_7200("7200");

    String name;

    RpnHDD(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
