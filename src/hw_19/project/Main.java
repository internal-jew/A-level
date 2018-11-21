package hw_19.project;

import hw_19.project.Utils.DataRandom;
import hw_19.project.Utils.Utils;
import hw_19.project.models.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> listOfPerson = new ArrayList<>();
        listOfPerson = Utils.getObjectFromFile(new File("Person.obj"));
        if (listOfPerson.size() == 0) {
            listOfPerson.addAll(getListOfRandomPerson(5));
            if (Utils.writeListOfPersonsToFile(new File("Person.obj"), listOfPerson)) {
                System.out.println("File 'Person.obj' is saved");
            }
        }
        PrintListOfPersons(listOfPerson);
    }


    private static int getNumberOfCreatedPersons() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of person that should be created by random:");
        int result;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Your enter is incorrect. May be positive int.");
            return 0;
        }

        return result > 0 ? result : 0;

    }


    private static void PrintListOfPersons(ArrayList<Person> listOfPersons) {
        for (Person person : listOfPersons
        ) {
            System.out.println(person);
        }
    }

    private static ArrayList<Person> getListOfRandomPerson(int numberOfCreatedPersons) {
        if (numberOfCreatedPersons == 0) {
            System.out.println("Incorrect enter. Program create 0 person and will be closed.");
        }
        DataRandom dataRandom = new DataRandom();
        Random random = new Random();
        ArrayList<Person> listOfPersons = new ArrayList<>();
        for (int i = 0; i < numberOfCreatedPersons; i++) {
            int caseForCreatePersons = random.nextInt(4);
            switch (caseForCreatePersons) {
                case 0:

                    listOfPersons.add(dataRandom.getRandomTeacher());
                    break;
                case 1:
                    listOfPersons.add(dataRandom.getRandomCollegeStudent());
                    break;
                case 2:
                    listOfPersons.add(dataRandom.getRandomStudent());
                    break;
                case 3:
                    listOfPersons.add(dataRandom.getRandomPerson());
                    break;
            }


        }
        return listOfPersons;
    }
}
/*
Sophia, age: 38, gender: M, subjects: Chemistry, Other, salary: 11915.0
Charlie, age: 12, gender: M, subjects: Chemistry, Other, salary: 13221.0
Jacob, age: 46, gender: F, student id: JZ27935, gpa: 2.0, year: 3, major: Undeclared
Jacob, age: 64, gender: M, student id: NN27085, gpa: 5.0, year: 4, major: Communications
Oscar, age: 81, gender: M, subjects: Chemistry, salary: 18560.0

Process finished with exit code 0
 */