package module.Utils;

public class Scanner {
    private String filename;
public static String getFileNameFromConsole(){
    java.util.Scanner scanner=new java.util.Scanner(System.in);
    return scanner.next();
}
}
