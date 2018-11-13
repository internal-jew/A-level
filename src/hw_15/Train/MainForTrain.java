package hw_15.Train;

import com.mysql.fabric.RangeShardMapping;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainForTrain {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static Enum<CityName> isUsedName = null;

    public static void main(String[] args) {


        int countOfCargoCarriage = getDataFromConsole("Enter count of CargoCarriage");
        int countOfPassengerCarriageFistClass = getDataFromConsole("Enter count of Passengers Carriage First Class");
        int countOfPassengerCarriageSecondClass = getDataFromConsole("Enter count of Passengers Carriage Second Class");


        Train train = new Train(countOfCargoCarriage, countOfPassengerCarriageFistClass, countOfPassengerCarriageSecondClass);
        System.out.println("Train goes from " + getRandomCityName() + " to " + getRandomCityName());
        System.out.println(train);

    }

    private static int getDataFromConsole(String message) {
        System.out.println(message);
        try {


            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Your enter was invalid.");
            System.exit(1);
        }

        return 0;
    }

    public static Enum<CityName> getRandomCityName() {
        Enum<CityName> newName = CityName.values()[random.nextInt(3)];
        while (newName == isUsedName) {
            newName = CityName.values()[random.nextInt(3)];
        }
        isUsedName = newName;
        return newName;
    }

}
