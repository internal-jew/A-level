package module;

import java.io.*;
import java.util.*;

public class Utils {
    public static String getDataFromConsole(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

   public static ArrayList<Integer>readDataFromFile(String filename) {
        ArrayList<Integer> resultArray=new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filename)
        ) {
            while (inputStream.available() > 0) {
                resultArray.add(inputStream.read());
            }
        } catch (IOException e) {
            System.out.println("An error occurred with reading file.");
        }

        return resultArray;
    }



    public static void writeToFile(CompressionResult compressionResult) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(changeResultFileName(compressionResult.getFileName(),".ccc"))) {
            int countOfBits = 0;

            fileOutputStream.write(Integer.toBinaryString(compressionResult.getBytes().size()).getBytes());
            fileOutputStream.write(String.valueOf('\\').getBytes());


            Bit[] concreteByte = new Bit[8];
            for (Bit bit : compressionResult.getBytes()
            ) {
                concreteByte[countOfBits] = bit;
                countOfBits++;
                if (countOfBits == 8) {
                    fileOutputStream.write(convertToInteger(concreteByte));
                    countOfBits = 0;
                }
            }
            if (countOfBits > 0) {
                while (countOfBits < 8) {
                    concreteByte[countOfBits] = Bit.ZERO;
                    countOfBits++;
                }
                fileOutputStream.write(convertToInteger(concreteByte));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFileTableKeys(CompressionResult compressionResult) {

        try (FileOutputStream fileOutputStream = new FileOutputStream
                (changeResultFileName(compressionResult.getFileName(),".key"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(compressionResult.getTableKey());
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public static void loadTableKeys(CompressionResult compressionResult) {
        // TODO: 18.11.2018
        try (FileInputStream fis = new FileInputStream(changeResultFileName(compressionResult.getFileName(), ".key"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            Map<String, ArrayList<Bit>> newKeyTable = (Map<String, ArrayList<Bit>>) objectInputStream.readObject();
       //     System.out.println(newKeyTable);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int convertToInteger(Bit[] bits) {
        int result = 0;
        String binaryValue = convertBitToString(bits);
        for (int i = 0; i < binaryValue.length(); i++) {
            result += Math.pow(2, i) * (binaryValue.charAt(i) == '1' ? 1 : 0);
        }
        return result;

    }

    private static String convertBitToString(Bit[] bits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Bit bit : bits
        ) {
            if (bit == Bit.ONE) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    private static String changeResultFileName(String originalFileName,String changeChars) {
        String result;
        if (originalFileName.contains(".")) {
            int indexOfSymbol = originalFileName.indexOf('.');
            result = originalFileName.substring(0, indexOfSymbol) + changeChars;
        } else {
            result = originalFileName + changeChars;
        }
        if (new File(result).exists()) {
            System.out.println("File with name: "+result +" has been overwrite." );
        }
        return result;
    }
}