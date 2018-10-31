package project;

import project.models.Person;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PrintListOfPersons(getListOfRandomPerson(getNumberOfCreatedPersons()));

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


    private static void PrintListOfPersons(Person[] listOfPersons) {
        for (Person person : listOfPersons
        ) {
            System.out.println(person);
        }
    }

    private static Person[] getListOfRandomPerson(int numberOfCreatedPersons) {
        if (numberOfCreatedPersons == 0) {
            System.out.println("Incorrect enter. Program create 0 person and will be closed.");
        }
        DataRandom dataRandom = new DataRandom();
        Random random = new Random();
        Person[] listOfPersons = new Person[numberOfCreatedPersons];
        for (int i = 0; i < numberOfCreatedPersons; i++) {
            int caseForCreatePersons = random.nextInt(4);
            switch (caseForCreatePersons) {
                case 0:

                    listOfPersons[i] = dataRandom.getRandomTeacher();
                    break;
                case 1:
                    listOfPersons[i] = dataRandom.getRandomCollegeStudent();
                    break;
                case 2:
                    listOfPersons[i] = dataRandom.getRandomStudent();
                    break;
                case 3:
                    listOfPersons[i] = dataRandom.getRandomPerson();
                    break;
            }


        }
        return listOfPersons;
    }
}