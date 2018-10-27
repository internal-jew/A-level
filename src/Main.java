import java.io.*;
import java.util.Scanner;

public class Main {
    private final static String PATH = "c:\\";

    public static void main(String[] args) {

        final String[] fileNamesList = takeFileNames();

        try {
            writeToFile(getTextFromFile(fileNamesList[1]), fileNamesList[0], false);
            writeToFile(getTextFromFile(fileNamesList[2]), fileNamesList[0], true);
        } catch (FileNotFoundException e) {
            System.out.println("One or more file are not found. Program will be closed");
            return;
        } catch (IOException e) {
            System.out.println("Found IOException. Program will be closed");
            //  e.printStackTrace();
            return;
        }
        System.out.println("Program replaced content in first file from second file content and append content from third file.");

    }

    private static StringBuilder getTextFromFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(PATH + fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        while (row != null) {
            stringBuilder.append(row);
            stringBuilder.append(System.lineSeparator());
            row = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return stringBuilder;
    }

    private static void writeToFile(StringBuilder stringBuilder, String fileName, boolean isAppend) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(PATH + fileName), isAppend);
        byte[] buffer = stringBuilder.toString().getBytes();
        fileOutputStream.write(buffer, 0, buffer.length);
        fileOutputStream.close();
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
