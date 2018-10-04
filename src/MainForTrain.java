import java.util.Scanner;

public class MainForTrain {
    public static void main(String[] args) {

        String[] towns={"Kharkov","Lvov","Kiev"};

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter count of CargoCarriage");
        int countOfCargoCarriage=scanner.nextInt();
        System.out.println("Enter count of Passengers Carriage First Class");
        int countOfPassengerCarriageFistClass=scanner.nextInt();
        System.out.println("Enter count of Passengers Carriage Second Class");
        int countOfPassengerCarriageSecondClass=scanner.nextInt();

        System.out.println("Enter town from:");
        String townFrom=scanner.next();

        System.out.println("Enter town to:");
        String townTo=scanner.next();


        Train train=new Train(countOfCargoCarriage,countOfPassengerCarriageFistClass,countOfPassengerCarriageSecondClass);
        System.out.println("Train goes from "+ townFrom+ " to "+townTo);
        System.out.println(train);

    }
}
