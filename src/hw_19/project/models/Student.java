package hw_19.project.models;

import hw_19.project.Utils.Utils;
import hw_19.project.constants.Gender;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final int MIN_GPA = 0;
    private static final int MAX_GPA = 5;
    private static final String REGEX = "[A-Z]{2,4}\\d{3,5}";
    private String idNumber;
    private double gpa;

    public void setGpa(double gpa) {
        Utils.validate(gpa, MIN_GPA, MAX_GPA);
        this.gpa = gpa;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public Student(String name, int age, Gender gender, String idNumber, double gpa) {
        super(name, age, gender);
        Utils.validate(gpa, MIN_GPA, MAX_GPA);
        Utils.validateString(REGEX, idNumber);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", student id: " + idNumber +
                ", gpa: " + gpa;
    }

    @Override
    public int compareTo(Person o) {
        if (o.getClass() == Student.class || o.getClass()==CollegeStudent.class) {
            Student person=(Student)o;
            if(gpa>person.gpa){
                return 1;
            }
            if(gpa<person.gpa){
                return -1;
            }
            return 0;
        }
        return 0;
    }
}