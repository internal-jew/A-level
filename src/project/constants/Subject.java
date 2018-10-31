package project.constants;

public enum Subject {
    COMPUTER_SCIENCE("Computer Science"),
    CHEMISTRY("Chemistry"),
    ENGLISH("English"),
    OTHER("Other");

    String name;

    Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}