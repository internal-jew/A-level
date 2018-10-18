public class Main {

    public static void main(String[] args) {
        Transport bicycle=new Bicycle("Ukraine",1972);
        Transport car=new Car("Chevrolet",2005);
        Transport helicopter=new Helicopter("Cooper",2016);
        Transport aircraft =new Aircraft("Boeing", 2000);

        ((Bicycle) bicycle).ride();
        System.out.println("---------------");
        ((Car) car).ride();
        System.out.println("---------------");
        ((Helicopter) helicopter).fly();
        System.out.println("---------------");
        ((Aircraft) aircraft).fly();
        System.out.println("---------------");
        ((Helicopter) helicopter).landing();
        System.out.println("---------------");
        ((Aircraft) aircraft).landing();
    }
}
