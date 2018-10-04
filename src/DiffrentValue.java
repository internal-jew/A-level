import java.util.ArrayList;

public class DiffrentValue {
    public static void main(String[] args) {

        int[] source = {0, 0, 1, 1, 1, 3, 1, 10};

        System.out.println("Count of different value is " + seachvalue(source));
    }

    private static int seachvalue(int[] source) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean isAllreadyInArray = false;
        for (int element : source
        ) {
            for (Integer elementInArrayList : result
            ) {
                if (element == elementInArrayList) {
                    isAllreadyInArray = true;
                }
            }
            if (!isAllreadyInArray) {
                result.add(element);
            } else isAllreadyInArray = false;
        }

        return result.size();
    }


}
