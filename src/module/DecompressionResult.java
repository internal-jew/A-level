package module;

import java.util.ArrayList;
import java.util.List;

public class DecompressionResult {
    private final String fileName;
    private final List<Bit> bytes;
    private final List<Integer> decompressedData;

    private DecompressionResult(List<Bit> bytes, ArrayList<Integer> decompressedData, String fileName) {
        this.fileName = fileName;
        this.bytes = bytes;
        this.decompressedData = decompressedData;
    }

    static DecompressionResultBuilder createBuilder(String fileName) {

        return new DecompressionResultBuilder(fileName);
    }


    static DecompressionResult createDecompressionResult(DecompressionResultBuilder decompressionResultBuilder) {
        return new DecompressionResult(decompressionResultBuilder.getBits(), decompressionResultBuilder.getDecompressedData(), decompressionResultBuilder.getFilename());
    }

    public String getFileName() {
        return fileName;
    }

    public List<Bit> getBytes() {
        return bytes;
    }

    public byte[] getDecompressedData() {
        byte[] result = new byte[decompressedData.size()];
        int i = 0;
        for (int number : decompressedData
        ) {
            result[i] = (byte) number;
            i++;
        }

        return result;
    }
}
