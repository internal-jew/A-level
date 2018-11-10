package hw_15.Train;

import java.util.Random;

public class CargoCarriage {
int capacity;

CargoCarriage(){
this.capacity=loadCarrige();
}

int loadCarrige(){
    return new Random().nextInt(99)+1;
    }

    @Override
    public String toString() {
        return "[CargoCarriage with capacity: "+this.capacity+"%]";
    }
}

