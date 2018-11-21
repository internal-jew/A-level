package hw_19.project.Utils;

import hw_19.project.models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Utils {
    private Utils() {

        throw new UnsupportedOperationException("This is util class");
    }


    public static ArrayList<Person> getObjectFromFile(File filename) {
        ArrayList<Person> listOfPersonFromFile = new ArrayList<>();
        if (filename.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(filename);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

              //  for (int i = 0; i < 5; i++) {
                    listOfPersonFromFile=(ArrayList<Person>)objectInputStream.readObject();
            //    }
                {

                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error with reading file 'Person.obj'");
                return listOfPersonFromFile;
            }
        }

        return listOfPersonFromFile;
    }

    public static boolean writeListOfPersonsToFile(File filename, ArrayList<Person> listOfPersons) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
          //  for (Person person : listOfPersons
          //  ) {
                objectOutputStream.writeObject(listOfPersons);
         //   }

        } catch (IOException e) {
            System.out.println("Error with writing to file 'Person.obj'");
            return false;
        }


        return true;
    }


    public static void validate(double arg, int from, int to) {
        if (arg < from || arg > to) {
            throw new IllegalArgumentException("Invalid parameter");
        }
    }


    public static void validateString(String regex, String idNumber) {
        if (!Pattern.matches(regex, idNumber)) {
            throw new IllegalArgumentException("Incorrect id");
        }
    }
}