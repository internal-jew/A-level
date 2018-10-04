import java.util.Scanner;

public class Chess {
    public static String[][] board = new String[8][8];

    public static void main(String[] args) {


        //  public static String[][] board = new String[8][8];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cell from");
        String initialCell = scanner.next();
        System.out.println("Enter cell to");
        String destinationCell = scanner.next();

        char initialRow = initialCell.charAt(0);
        char initialCol = initialCell.charAt(1);

        char destinationRow = destinationCell.charAt(0);
        char destinationCol = destinationCell.charAt(1);

int[] initcoordinats=boardresource(initialRow,initialCol);
int[] destinationcoordinats=boardresource(destinationRow,destinationCol);

        System.out.println(isAllow(initcoordinats,destinationcoordinats)?"Move is allow":"Move is NOT allow");
      //  System.out.println(initcoordinats[0]+" "+initcoordinats[1]);





    }

    public static int[] boardresource(char first, char second) {
        char[] rows = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] cols = {'1', '2', '3', '4', '5', '6', '7', '8'};
        int[]result=new int[2];
        for (int i = 0; i < rows.length; i++) {
            if (first==rows[i]){
                result[0]=i+1;
            }
            if(second==cols[i]){
                result[1]=i+1;
            }
        }



        return result;
    }

    public static boolean isAllow(int[]init,int[]destination){
      //  int[]allowRow;
    //    int[] allowCol=new int[4];


        if(init[0]+1==destination[0] & init[1]-2==destination[1]     ||     init[0]+2==destination[0] & init[1]-1==destination[1]   ||  init[0]+2==destination[0] & init[1]+1==destination[1]     || init[0]+1==destination[0] & init[1]+2==destination[1]   || init[0]-1==destination[0] & init[1]-2==destination[1]     || init[0]-2==destination[0]  &  init[1]-1==destination[1]       ||    init[0]-2==destination[0]  &  init[1]+1==destination[1]     ||     init[0]-1==destination[0] & init[1]+2==destination[1] ){
            return true;
        }
        else{
            return false;
        }

             }





        //return false;
    }


