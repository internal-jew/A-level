import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Transport> listTransport = new ArrayList<>();
        Transport bicycle = new Bicycle("Ukraine", 1972);
        Transport car = new Car("Chevrolet", 2005);
        Transport helicopter = new Helicopter("Cooper", 2016);
        Transport aircraft = new Aircraft("Boeing", 2000);

        Helicopter helicopter2 = (Helicopter) helicopter;

        Transport helicopter3=new Helicopter("Cooper" ,2016);
        listTransport.add(bicycle);
        listTransport.add(car);
        listTransport.add(helicopter);
        listTransport.add(aircraft);

        System.out.println(car.equals(bicycle));
        System.out.println(helicopter.equals(helicopter3));
        System.out.println("---------------");

        System.out.println(car.hashCode()==bicycle.hashCode());
        System.out.println(helicopter.hashCode()==helicopter3.hashCode());
        System.out.println("---------------");

        for (Transport transport : listTransport
        ) {
            transport.move();
            System.out.println("---------------");
        }


    }
}
