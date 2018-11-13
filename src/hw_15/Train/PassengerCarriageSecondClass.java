package hw_15.Train;

import java.util.Random;

public class PassengerCarriageSecondClass {
    int capacity;


    PassengerCarriageSecondClass() {
        this.capacity = loadCarrige();
    }


    int loadCarrige() {
        return new Random().nextInt(199) + 1;
    }

    @Override
    public String toString() {
        return "[PassSecondClass with " + this.capacity + " passengers]";
    }
}

