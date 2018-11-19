package module;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class CompressionResult {
    private final String fileName;
    private final List<Bit> bytes;
    private final TreeMap<String, ArrayList<Bit>> tableKey;

    private CompressionResult(List<Bit> bytes, TreeMap<String, ArrayList<Bit>> tableKey, String fileName) {
        this.fileName = fileName;
        this.bytes = bytes;
        this.tableKey = tableKey;
    }

    public TreeMap<String, ArrayList<Bit>> getTableKey() {
        return tableKey;
    }

    public String getFileName() {
        return fileName;
    }

    public List<Bit> getBytes() {
        return bytes;
    }

    static CompressionResultBuilder createBuilder() {

        return new CompressionResultBuilder();
    }

    static CompressionResult createCompressionResult(CompressionResultBuilder resultBuilder) {
        return new CompressionResult(resultBuilder.getBits(), resultBuilder.getTableKey(), resultBuilder.getFilename());
    }

}
