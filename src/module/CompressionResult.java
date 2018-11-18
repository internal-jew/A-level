package module;

import java.util.ArrayList;
import java.util.List;


public class CompressionResult {
    private final String fileName;
    private List<Character> bytes;

   private CompressionResult(List<Character> bytes, String fileName) {
        this.fileName = fileName;
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public List<Character> getBytes() {
        return bytes;
    }

    static ResultBuilder createBuilder() {
        return new ResultBuilder();
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
public static class ResultBuilder {
    private CompressionResult compressionResult;
    private String filename="";
    private ArrayList<Character> bits=new ArrayList<>();

    // Defend
    ResultBuilder() {
    }



    /*  ResultBuilder addBit(Bit bit) {
      if(bit==Bit.ONE){
          bits.add(1);
      }
      else {
          bits.add(0);
      }
          return this;
      }

      ResultBuilder addBit(Integer bit) {

              bits.add(bit);

          return this;
      }*/
    ResultBuilder addBit(char bit) {

        bits.add(bit);

        return this;
    }

    ResultBuilder setFileName(String fileName) {
        this.filename = fileName;
        return this;
    }
    CompressionResult build(){

        return compressionResult=new CompressionResult(bits,filename);

        //   return null;
    }
}

}
