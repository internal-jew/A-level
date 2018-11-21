package hw_19.project.models;


import hw_19.project.Utils.DataRandom;
import hw_19.project.Utils.Utils;
import hw_19.project.constants.Gender;

import java.io.Serializable;


public class Person implements Comparable<Person>, Serializable {
    private String name;
    private int age;
    private Gender gender;
static DataRandom dataRandom=new DataRandom();

    public Person(String name, int age, Gender gender) {

        Utils.validate(age, 0, 100);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name +
                ", age: " + age +
                ", gender: " + gender;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
