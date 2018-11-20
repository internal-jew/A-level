package hw_19;

import java.io.File;
import java.util.*;

public class WriteToFile {
    public static void main(String[] args) {
        System.out.println("Enter directory:");
        try {
            printResult(readDirectoryTreeFrom(new File(new Scanner(System.in).next())));

        } catch (Exception e) {
            System.out.println("Directory not found");
        }
    }

    private static List<File> readDirectoryTreeFrom(File directory) {
        List<File> result = new ArrayList<>();
        Queue<File> fileQueue = new PriorityQueue<>();
        Collections.addAll(fileQueue, Objects.requireNonNull(directory.listFiles()));

        while (!fileQueue.isEmpty()) {
            File currentFile = fileQueue.remove();
            if (currentFile.isDirectory()) {
                result.add(currentFile);
                Collections.addAll(fileQueue, Objects.requireNonNull(currentFile.listFiles()));
            } else {
                result.add(currentFile);
            }
        }
        return result;
    }


    private static void printResult(List<File> listOfFile) {
        for (File fileName : listOfFile
        ) {
            int tabulation = fileName.getAbsolutePath().length() - fileName.getAbsolutePath().replace("\\", "").length() + 1;

            for (int i = 0; i < tabulation; i++) {
                System.out.print("  ");
            }
            if (fileName.isDirectory()) {
                System.out.println("\033[32m " + fileName.getName() + " : " + fileName.lastModified());
            } else {
                System.out.println("\033[34m " + fileName.getName() + " : " + fileName.lastModified());
            }


        }
    }


}
