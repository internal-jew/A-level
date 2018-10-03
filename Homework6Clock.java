public class Homework6Clock {
    public static void main(String[] args) {
        int result = 0;
        for (int firstLeftNumber = 0; firstLeftNumber <= 2; firstLeftNumber++) {
            for (int secondLeftNumber = 0; secondLeftNumber < 6; secondLeftNumber++) {
                for (int secondRightNumber = 0; secondRightNumber <= 2; secondRightNumber++) {
                    for (int firstRightNumber = 0; firstRightNumber < 6; firstRightNumber++) {
                        if (secondRightNumber == 2 && firstRightNumber == 4 && firstLeftNumber == 2 && secondLeftNumber == 4) {
                            System.out.println("Count of symmetric sets: "+result);
                            return;
                        }
                        if (firstLeftNumber == secondRightNumber && secondLeftNumber == firstRightNumber) {
                            result++;
                        }
                    }
                }
            }

        }
	System.out.println ("Count of symmetric value is: "+result);
    }
}
