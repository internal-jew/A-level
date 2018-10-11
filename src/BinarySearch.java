import java.util.Scanner;

public class BinarySearch {
   private static int countOfIteration =0;
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Enter number");
        Scanner scanner=new Scanner(System.in);
        binarySearch(source,scanner.nextInt(),0,source.length-1);
    }


    private static void binarySearch(int[] source, int number, int start, int end) {
       countOfIteration++;
        if (end - start == 2 && source[(end + start) / 2] != number) {
            System.out.println("Integer " + number + " is absent in array");
            return;
        }
        if (source[(end + start) / 2] == number) {
            System.out.println("Number have been find in array at position [" + (end + start) / 2 + "] by "+ countOfIteration +" recursive search.");
            return;
        }
        if (source[(end+start)/2]>number){
            binarySearch(source,number,start,(end+start)/2);
        }
        else{
            binarySearch(source,number,(end+start)/2,end);
        }

    }
}
