package Enumeration;

public enum TypeHdd {
    INTERNAL_NOTEBOOK("Internal for notebook"),
    INTERNAL_DESKTOP("Internal for desktop"),
    EXTERNAL ("External");

    String name;
    TypeHdd(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
