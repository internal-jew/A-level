package module;

import java.util.ArrayList;
import java.util.List;


public class CompressionResult {
    private final String fileName;
    private List<Bit> bytes;

   private CompressionResult(List<Bit> bytes, String fileName) {
        this.fileName = fileName;
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public List<Bit> getBytes() {
        return bytes;
    }

    static ResultBuilder createBuilder() {

       return new ResultBuilder();
    }
    static CompressionResult createCompressionResult(ResultBuilder resultBuilder){
       return new CompressionResult(resultBuilder.getBits(),resultBuilder.getFilename());
    }

/*
1. Node
    value
    weight
    2 child
2. Create dictionary частотный словарь
    PriorityQueue
3. Create table (a-0, b-01, c-00110
4. Result (int[])
5. Записать файл и таблицу


1. Прочитать из файла результат и таблицу
2. Востановить из результата Zero One
3. Расжать


 */


}
