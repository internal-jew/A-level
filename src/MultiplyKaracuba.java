import java.util.Scanner;

public class MultiplyKaracuba {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----Multiplication by Karacuba----");
        System.out.println("Enter first number");
        long first = scanner.nextInt();
        System.out.println("Enter second number");
        long second = scanner.nextInt();


        if (String.valueOf(first).length()==String.valueOf(second).length()) {
            System.out.println("Result of multiplication is: " + multiply(first, second));
        }
        System.out.println("Error: Numbers should be same length");
    }

    private static long multiply(long first, long second) {

        long a, b, c, d; //Variable for parts of number

        if (first < 1000 || second < 1000 || String.valueOf(first).length()!=String.valueOf(second).length()) { // if length of number less than 4 digits or not same length - we use simple multiply
            return first * second;
        }

   int addOneForOdd=0;//variable for odd numbers come +1
        if (String.valueOf(first).length() % 2 != 0){
            addOneForOdd=1;
        }
        a = Long.valueOf(String.valueOf(first).substring(0, (String.valueOf(first).length() / 2) + addOneForOdd));
        b = Long.valueOf(String.valueOf(first).substring((String.valueOf(first).length() / 2) + addOneForOdd));
        c = Long.valueOf(String.valueOf(second).substring(0, (String.valueOf(second).length() / 2) + addOneForOdd));
        d = Long.valueOf(String.valueOf(second).substring((String.valueOf(second).length() / 2) + addOneForOdd));

// Recursive method
        return multiply(a, c) * countOfZero(first) / (addOneForOdd==1?10:1) + ((multiply((a + b), (c + d))) - (multiply(a, c)) - multiply(b, d)) * countOfZero(b) + multiply(b, d);
//(addOneForOdd==1?10:1) this means that for odd number we devide by 10 otherwise we do nothing (devide by 1)

    }

    private static long countOfZero(long number) {
        long result = 1;
        while (String.valueOf(number).length() != (String.valueOf(result).length())) {
            result *= 10;
        }
        return result * 10;
    }

}
