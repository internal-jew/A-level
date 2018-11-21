package hw_19.project.models;

import hw_19.project.Utils.Utils;
import hw_19.project.constants.Gender;
import hw_19.project.constants.Major;

import java.io.Serializable;

public class CollegeStudent extends Student implements Serializable {

    private static final int MIN_YEAR = 1;
    private static final int MAX_YEAR = 5;
    private int year;
    private Major major;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Utils.validate(year, MIN_YEAR, MAX_YEAR);
        this.year = year;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public CollegeStudent(String name, int age, Gender gender, String idNumber, double gpa, int year, Major major) {
        super(name, age, gender, idNumber, gpa);
        Utils.validate(year, MIN_YEAR, MAX_YEAR);
        this.year = year;
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", year: " + year +
                ", major: " + major;
    }
}
