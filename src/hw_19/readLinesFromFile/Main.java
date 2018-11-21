package hw_19.readLinesFromFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fileName = new File(getDataFromConsole("Enter filename for read"));
        int countOfLinesToRead = Integer.valueOf(getDataFromConsole("Enter count of lines to read"));
        File outputFileName = new File(getDataFromConsole("Enter output filename"));

        if(getDataFromConsole("Use NIO - press '1' , else will be used IO").equals("1")){
            List<String> linesFromFile = readDataFromFileNIO(fileName, countOfLinesToRead);
            writeToFileNIO(outputFileName, linesFromFile);
        }
        else {
            List<String> linesFromFile = readDataFromFileIO(fileName, countOfLinesToRead);
            writeToFileIO(outputFileName, linesFromFile);
        }

    }

    private static void writeToFileNIO(File fileName, List<String> data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            Files.write(Paths.get(fileName.getName()), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFileIO(File fileName, List<String> data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line:data
                 ) {
                writer.write(line);
                writer.write("\n");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<String> readDataFromFileNIO(File fileName, int countOfLinesToRead) {
        if (fileName.exists()) {
            List<String> result = new ArrayList<>();
            try {
                Files.lines(Paths.get(fileName.getName()), StandardCharsets.UTF_8).forEach(result::add);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return countOfLinesToRead < result.size() ? result.subList(0, countOfLinesToRead) : result;
        }

        System.out.println("File do not exists");
        System.exit(1);
        return null;
    }


    private static List<String> readDataFromFileIO(File fileName, int countOfLinesToRead) {
        if (fileName.exists()) {
            List<String> result = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return countOfLinesToRead < result.size() ? result.subList(0, countOfLinesToRead) : result;
        }

        System.out.println("File do not exists");
        System.exit(1);
        return null;
    }


    private static String getDataFromConsole(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
