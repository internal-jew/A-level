package module;

import java.io.*;
import java.util.*;

public class Utils {
    public static String getDataFromConsole(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static ArrayList<Integer> readDataFromFile(String filename) {
        ArrayList<Integer> resultArray = new ArrayList<>();
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
        try (FileOutputStream fileOutputStream = new FileOutputStream(compressionResult.getFileName() + ".hf")) {
            int countOfBits = 0;

            fileOutputStream.write(Integer.toBinaryString(compressionResult.getBytes().size()).getBytes());
            fileOutputStream.write(String.valueOf('2').getBytes());


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

    public static void writeToFile(DecompressionResult deCompressionResult) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(deCompressionResult.getFileName().substring(0, deCompressionResult.getFileName().length() - 3))) {
            fileOutputStream.write(deCompressionResult.getDecompressedData());

        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(deCompressionResult.getFileName());
        file.delete();
        file = new File(deCompressionResult.getFileName().substring(0, deCompressionResult.getFileName().length() - 7) + ".key");
        file.delete();

    }


    public static void writeToFileTableKeys(CompressionResult compressionResult) {

        try (FileOutputStream fileOutputStream = new FileOutputStream
                (getFileNameWithoutExtension(compressionResult.getFileName()) + ".key");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(compressionResult.getTableKey());
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public static Map<String, ArrayList<Bit>> loadTableKeys(String filename) {
        Map<String, ArrayList<Bit>> keyTable = null;
        try (FileInputStream fis = new FileInputStream(getFileNameWithoutExtension(filename) + ".key");
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            keyTable = (Map<String, ArrayList<Bit>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return keyTable;
    }


    public static ArrayList<Bit> readDataFromCompressedFile(String filename) {
        ArrayList<Bit> bits = new ArrayList<>();
        ArrayList<Bit> countOfBits = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(filename)
        ) {
            int tempInputStream = inputStream.read();

            while (tempInputStream != 50) {
                if (tempInputStream == 49) {
                    countOfBits.add(Bit.ONE);
                } else {
                    countOfBits.add(Bit.ZERO);
                }
                tempInputStream = inputStream.read();
            }
            Bit[] count = new Bit[countOfBits.size()];
            int i = 0;
            for (Bit bit : countOfBits
            ) {
                count[i] = bit;
                i++;
            }
            //  count.
            int lengthOfData = convertToInteger(count);


            while (inputStream.available() > 0) {
                String bin = Integer.toBinaryString(inputStream.read());
                while (bin.length() < 8) {
                    bin = "0" + bin;
                }
                for (char character : bin.toCharArray()
                ) {
                    lengthOfData -= 1;

                    if (character == 49) {
                        bits.add(Bit.ONE);
                    } else {
                        bits.add(Bit.ZERO);
                    }
                }
            }
            while (lengthOfData != 0) {
                bits.remove(bits.size() - 1);
                lengthOfData += 1;
            }


            System.out.println(bits.size());

        } catch (IOException e) {
            System.out.println("An error occurred with reading file.");
        }

        return bits;
    }


    private static int convertToInteger(Bit[] bits) {
        // int result = 0;
        String binaryValue = convertBitToString(bits);
        return Integer.parseInt(binaryValue, 2);
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

    private static String getFileNameWithoutExtension(String originalFileName) {
        String result;
        if (originalFileName.contains(".")) {
            int indexOfSymbol = originalFileName.indexOf('.');
            result = originalFileName.substring(0, indexOfSymbol);
        } else {
            result = originalFileName;
        }
        if (new File(result).exists()) {
            System.out.println("File with name: " + result + " has been overwrite.");
        }
        return result;
    }
}