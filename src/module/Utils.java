package module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {
    public static String getFileNameFromConsole() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.next();
    }

    public static void writeToFile(CompressionResult compressionResult) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(changeResultFileName(compressionResult.getFileName()))) {
            int countOfBits = 0;
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
        } catch (
                IOException e) {
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

    private static String changeResultFileName(String originalFileName) {
        String result = "";
        if (originalFileName.contains(".")) {
            int indexOfSymbol = originalFileName.indexOf('.');
            result = originalFileName.substring(0, indexOfSymbol) + ".ccc";
        } else {
            result = originalFileName + ".ccc";
        }
        if (new File(result).exists()) {
            System.out.println("Attention! File has been overloaded!");
        }
        return result;
    }
}