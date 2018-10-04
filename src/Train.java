import java.util.ArrayList;

public class Train {
int countCarriage;
ArrayList<CargoCarriage> Cargos=new ArrayList<>();
ArrayList<PassengerCarriageFistClass> PassFirst=new ArrayList<>();
ArrayList<PassengerCarriageSecondClass> PassSecond=new ArrayList<>();

Train(int countOfCargoCarriage, int countOfPassengerCarriageFirstClass, int countOfPassengerCarriageSecondClass){
    for (int i = 0; i <countOfCargoCarriage ; i++) {
        CargoCarriage cargo=new CargoCarriage();
        Cargos.add(cargo);
    }
    for (int i = 0; i < countOfPassengerCarriageFirstClass; i++) {
        PassengerCarriageFistClass passFirst=new PassengerCarriageFistClass();
        PassFirst.add(passFirst);
    }
    for (int i = 0; i < countOfPassengerCarriageSecondClass; i++) {
        PassengerCarriageSecondClass passSecond=new PassengerCarriageSecondClass();
        PassSecond.add(passSecond);
    }

}

    @Override
    public String toString() {
    String result="Locomotiv-------";
        for (CargoCarriage wagen:Cargos
             ) {
            result+=wagen;
            result+="-------";
        }
        for (PassengerCarriageFistClass wagen:PassFirst
        ) {
            result+=wagen;
            result+="-------";
        }

        for (PassengerCarriageSecondClass wagen:PassSecond
        ) {
            result+=wagen;
            result+="-------";
        }




    return result;
    }
}
