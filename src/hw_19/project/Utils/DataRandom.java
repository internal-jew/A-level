package hw_19.project.Utils;

import hw_19.project.constants.Gender;
import hw_19.project.constants.Major;
import hw_19.project.constants.Subject;
import hw_19.project.models.CollegeStudent;
import hw_19.project.models.Person;
import hw_19.project.models.Student;
import hw_19.project.models.Teacher;

import java.util.ArrayList;
import java.util.Random;

public class DataRandom {
    private static Random random = new Random();


    public Teacher getRandomTeacher() {
        int countOfTryToFillSubjectsList = random.nextInt(5) + 1;
        ArrayList<Subject> tempArrayList = new ArrayList<>();
        for (int i = 0; i < countOfTryToFillSubjectsList; i++) {
            Subject tempSubject = getRandomEnum(Subject.class);
            if (!tempArrayList.contains(tempSubject)) {
                tempArrayList.add(tempSubject);
            }
        }
        Subject[] listOfSubjects = new Subject[tempArrayList.size()];
        int i = 0;
        for (Subject item : tempArrayList
        ) {
            listOfSubjects[i++] = item;

        }
        return new Teacher(getRandomName(), getRandomAge(),
                getRandomEnum(Gender.class), getRandomSalary(),
                listOfSubjects);

    }

    public CollegeStudent getRandomCollegeStudent() {
        return new CollegeStudent(getRandomName(), getRandomAge(),
                getRandomEnum(Gender.class), getRandomIdNumber(),
                getRandomGPA(), getRandomYear(), getRandomEnum(Major.class));
    }

    public Student getRandomStudent() {
        return new Student(getRandomName(), getRandomAge(), getRandomEnum(Gender.class), getRandomIdNumber(), getRandomGPA());
    }

    public Person getRandomPerson() {
        return new Person(getRandomName(), getRandomAge(), getRandomEnum(Gender.class));
    }


    private String getRandomName() {
        //random=new Random(20);
        //return names[new Random(names.length).nextInt()];
        return names[random.nextInt(names.length)];
    }

    private int getRandomAge() {
        //return new Random(110).nextInt();
        return random.nextInt(100);

    }

    //  Gender getRandomGender(){
    //      return new Random().nextBoolean()? Gender.MALE:Gender.FEMALE;
    //  }

    private double getRandomSalary() {
        //     return new Random(20000).nextDouble();
        return 1000 + (19000 * random.nextDouble());
    }

    private <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    private double getRandomGPA() {
        //return new Random(5).nextDouble()+1;
        return random.nextInt(5) + 1;
    }

    private int getRandomYear() {
        return random.nextInt(5) + 1;
    }

    private String getRandomIdNumber() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            result.append(letters[random.nextInt(letters.length)]);
        }
        while (result.length() < 7) {
            result.append(random.nextInt(10));
        }
        return result.toString();


    }


    private String[] names = {"Olivia", "Oliver", "Amelia", "Harry", "Isla", "Jack", "Emily", "George", "Ava", "Noah", "Lily", "Charlie",
            "Mia", "Jacob", "Sophia", "Alfie", "Isabella", "Freddie", "Grace", "Oscar"};


}
