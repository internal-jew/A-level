import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {
    public static void read(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.readLine() != null) {
            System.out.println(reader.readLine());
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {


            read("c:\\setup.log");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
