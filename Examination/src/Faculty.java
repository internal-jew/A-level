
import java.util.ArrayList;

public class Faculty {

    private static final int PASSINGSCORE = 3; //Проходной бал на факультете

    private String name = "Informatic Science"; //Название факультета
    ArrayList<Enrollee> registeredEnrolles = new ArrayList<>();//Список зарегистрированных абитуриентов
    private ArrayList<Enrollee> students = new ArrayList<>(); // Список студентов (абитуриенты средний бал которых выше или равно проходному)
    Professor professor; //Профессор закрепленный за факультетом

    public void checkPassingScore() { // Метод заполнения списка студентов из списка абитуриентов
        students.clear();
        for (Enrollee student : registeredEnrolles
        ) {
            if (student.exams.averageMark >= PASSINGSCORE) {
                students.add(student);

            }
        }
    }

    public void printListStudents() { //Метод вывода на экран информации факультета
        System.out.println("INFORMATION of faculty " + name);
        System.out.println("Average mark to became student is " + PASSINGSCORE);
        System.out.println();
        int counter = 1;

        if (students.size() > 0) {
            System.out.println("CONGRATULATION to our new students:");

            for (Enrollee student : students
            ) {
                System.out.println(counter + ". " + student + ". " + student.exams);
                registeredEnrolles.remove(student);
                counter++;
            }


        }
        System.out.println();
        counter = 1;
        if (registeredEnrolles.size() > 0) System.out.println("List of NOT credited enrollees:");
        for (Enrollee enrollee : registeredEnrolles
        ) {
            System.out.println(counter + ". " + enrollee + ". " + enrollee.exams);
            counter++;
        }


    }

    Faculty(String name) { //Конструктор
        this.name = name;
    }

}
