import java.io.*;
import java.util.Scanner;

public class Main {
    private final static String PATH = "c:\\";

    public static void main(String[] args) {

        final String[] fileNamesList = takeFileNames();

        writeToFile(getTextFromFile(fileNamesList[1]), fileNamesList[0], false);
        writeToFile(getTextFromFile(fileNamesList[2]), fileNamesList[0], true);

        System.out.println("Program replaced content in first file from second file content and append content from third file.");

    }

    private static StringBuilder getTextFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(PATH + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String row = bufferedReader.readLine();
            while (row != null) {
                stringBuilder.append(row);
                stringBuilder.append(System.lineSeparator());
                row = bufferedReader.readLine();
            }
            // bufferedReader.close();
            // fileReader.close();

        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(1);
        }
        return stringBuilder;
    }

    private static void writeToFile(StringBuilder stringBuilder, String fileName, boolean isAppend) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(PATH + fileName), isAppend)) {
            byte[] buffer = stringBuilder.toString().getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(1);
        }
    }


    private static String[] takeFileNames() {
        final String[] stringNameOfCountOfFile = {"first", "second", "third"};
        String[] fileNameList = new String[3];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter name of " + stringNameOfCountOfFile[i] + " file");
            fileNameList[i] = scanner.next();
        }
        return fileNameList;
    }
}
