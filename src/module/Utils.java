package module;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    private String filename;

    public static String getFileNameFromConsole() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.next();
    }

    public static void writeToFile(CompressionResult compressionResult) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("d:\\Test.ccc")) {

            int cou=0;

            int countOfBits = 0;
            byte[] newByte = new byte[8];
            for (Bit bit : compressionResult.getBytes()
            ) {
                if (bit == Bit.ONE) {
                    newByte[countOfBits] = 1;
                } else {
                    newByte[countOfBits] = 0;
                }
                countOfBits++;
                if (countOfBits == 8) {

                    cou++;

                    countOfBits = 0;
                    fileOutputStream.write(newByte);
                }

            }
            if (countOfBits > 0) {
                while (countOfBits < 8) {
                    newByte[countOfBits] = 0;
                    countOfBits++;
                }


                fileOutputStream.write(newByte);

            }

            System.out.println(cou);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
