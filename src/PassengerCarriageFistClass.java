import java.util.Random;

public class PassengerCarriageFistClass {
    int capacity;


    PassengerCarriageFistClass(){
        this.capacity=loadCarrige();
    }


    int loadCarrige(){
        return new Random().nextInt(99)+1;
    }

    public String toString() {
        return "[PassFistClass with "+this.capacity+" passengers]";
    }
}
