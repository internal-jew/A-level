import BuilderUtils.BuilderHdd;
import BuilderUtils.HardDrive;

import java.util.ArrayList;

public class Main {
//All exception in this code is unchecked, that is why we should not necessarily insert it in try-catch block.
    public static void main(String[] args) {
        ArrayList<HardDrive> hardDrivesArray = new ArrayList<>();

        Director director = new Director();
        BuilderHdd builderHdd = new BuilderHdd();

        director.makeExternalHddForDesktop(builderHdd);
        hardDrivesArray.add(builderHdd.getHDD());
        director.makeInternalHddForDesktop(builderHdd);
        hardDrivesArray.add(builderHdd.getHDD());
        director.makeInternalHddForNotebook(builderHdd);
        hardDrivesArray.add(builderHdd.getHDD());


     for (int i = 0; i <= hardDrivesArray.size(); i++) { //forth exception IndexOutOfBoundsException

          //  for (int i = 0; i < hardDrivesArray.size(); i++) {
            System.out.println(hardDrivesArray.get(i));
        }

    }
}
