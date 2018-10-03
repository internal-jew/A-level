public class Enrollee {
    private String name;
    private String secondName;
    private String lastName;
    Exams exams;

    public void registration(Faculty faculty) {//Метод регистрации абитуриента на факультете
        faculty.registeredEnrolles.add(this);
    }


    Enrollee(String name, String secondName, String lastName) { //Конструктор
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    Enrollee(String name, String lastName) { // Конструктор
        this.name = name;
        this.lastName = lastName;
        this.secondName = "";
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + lastName;
    }
}
