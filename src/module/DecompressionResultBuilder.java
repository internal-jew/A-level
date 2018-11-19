package module;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DecompressionResultBuilder {
    private String filename = "";
    private ArrayList<Bit> bits = new ArrayList<>();
    private ArrayList<Integer> decompressedData = new ArrayList<>();
    private Map<String, ArrayList<Bit>> tableKey = new TreeMap<>();


    DecompressionResultBuilder(String filename) {
        if (filename.substring(filename.length() - 3).equals(".hf")) {
            this.filename = filename;
        } else {
            System.out.println("File is not compressed.");
        }

    }


    DecompressionResultBuilder loadTableKeys() {
        tableKey = Utils.loadTableKeys(filename);
        return this;
    }

    DecompressionResultBuilder readDataFromCompressedFile() {
        bits = Utils.readDataFromCompressedFile(filename);
        return this;
    }

    DecompressionResultBuilder restoreOriginalData() {
        ArrayList<Bit> temporaryArrayOfBits = new ArrayList<>();
        for (Bit bit : bits
        ) {
            temporaryArrayOfBits.add(bit);
            if (tableKey.containsValue(temporaryArrayOfBits)) {
                for (Map.Entry<String, ArrayList<Bit>> entry : tableKey.entrySet()
                ) {
                    if (entry.getValue().equals(temporaryArrayOfBits)) {
                        decompressedData.add(Integer.valueOf(entry.getKey()));
                        temporaryArrayOfBits.clear();
                        break;
                    }
                }

            }


        }

        return this;
    }

    DecompressionResult build() {
        return DecompressionResult.createDecompressionResult(this);
    }

    public String getFilename() {
        return filename;
    }

    public ArrayList<Bit> getBits() {
        return bits;
    }

    public ArrayList<Integer> getDecompressedData() {
        return decompressedData;
    }
}