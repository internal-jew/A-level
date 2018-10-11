import java.util.Scanner;

public class MultiplyByColums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Multiplication by colums----");
        System.out.println("Enter first number");
        long first = scanner.nextInt();
        System.out.println("Enter second number");
        long second = scanner.nextInt();
        System.out.println("Result of multiplication is: " + multiply(first, second));

    }

    private static long multiply(long first, long second) {
        int result = 0;
        int[] firstArrayDigits, secondArrayDigits;

        firstArrayDigits = forIntegerArray(first);
        secondArrayDigits = forIntegerArray(second);

        for (int i = 0; i < firstArrayDigits.length; i++) {
            for (int j = 0; j < secondArrayDigits.length; j++) {
                result += firstArrayDigits[i] * countOfZero(i) * secondArrayDigits[j] * countOfZero(j);
            }
        }
        return result;
    }

    private static long countOfZero(int number) {
        long result = 1;
        for (int i = 0; i < number; i++) {
            result *= 10;
        }
        return result;
    }


    private static int[] forIntegerArray(long number) {
        int[] result = new int[String.valueOf(number).length()];
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            result[i] = Integer.valueOf(String.valueOf(number).substring(String.valueOf(number).length() - 1 - i, String.valueOf(number).length() - i));
        }
        return result;
    }

}
