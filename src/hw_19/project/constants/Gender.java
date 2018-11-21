package hw_19.project.constants;

public enum Gender {
    MALE("M"),
    FEMALE("F");
String name;
    Gender(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
