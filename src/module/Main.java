package module;

public class Main {
    public static void main(String[] args) {


        if (Utils.getDataFromConsole("Press '1' to compress file or '0' to decompress").equals("1")) {
            CompressionResult result = CompressionResult
                    .createBuilder()
                    .readDataFromFile(Utils.getDataFromConsole("Enter absolute fileName that will be compress: "))
                    .createFrequencyDictionary()
                    .createTreeNodes()
                    .createKeysTable()
                    .codingFile()
                    .build();

            Utils.writeToFile(result);
            Utils.writeToFileTableKeys(result);


        } else {
            DecompressionResult result = DecompressionResult
                    .createBuilder(Utils.getDataFromConsole("Enter absolute fileName that will be decompress: "))
                    .loadTableKeys()
                    .readDataFromCompressedFile()
                    .restoreOriginalData()
                    .build();

            Utils.writeToFile(result);
        }

    }
}