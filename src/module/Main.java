package module;

public class Main {
    public static void main(String[] args) {

        CompressionResult result = CompressionResult
                .createBuilder()
                .readDataFromFile(Utils.getFileNameFromConsole())
                .createFrequencyDictionary()
                .createTreeNodes()
                .createKeysTable()
                .codingFile()
                .build();

        Utils.writeToFile(result);

    }
}