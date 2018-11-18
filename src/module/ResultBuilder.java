package module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import static module.Bit.ONE;
import static module.Bit.ZERO;

public class ResultBuilder {
    private String filename = "";
    private ArrayList<Bit> bits = new ArrayList<>();
    private List<Integer> originalDataFromFile = new ArrayList<>();
    private ArrayList<Node> listOfNode = new ArrayList<>();
    private ArrayList<Node> temporaryListOfNodes = new ArrayList<>();
    private TreeMap<String, ArrayList<Bit>> tableKey = new TreeMap<>();


    ResultBuilder() {
    }

    public String getFilename() {
        return filename;
    }

    public ArrayList<Bit> getBits() {
        return bits;
    }


    ResultBuilder readDataFromFile(String filename) {
        try (FileInputStream inputStream = new FileInputStream("d:\\Test.rtf")
        ) {
            this.filename = filename;
            while (inputStream.available() > 0) {
                originalDataFromFile.add(inputStream.read());
            }
        } catch (IOException e) {
            System.out.println("An error occurred with reading file.");
        }
        return this;
    }

    ResultBuilder createFrequencyDictionary() {
        for (Integer value : originalDataFromFile
        ) {
            if (Node.getNodeByValue(listOfNode, String.valueOf(value)) != null) {
                Node.getNodeByValue(listOfNode, String.valueOf(value)).setWeight(Node.getNodeByValue(listOfNode, String.valueOf(value)).getWeight() + 1);
            } else {
                listOfNode.add(new Node(String.valueOf(value), 1));
            }
            listOfNode.sort(Comparator.comparingInt(Node::getWeight));

        }
        return this;
    }

    ResultBuilder createTreeNodes() {
        Node node1, node2;
        temporaryListOfNodes.addAll(listOfNode);
        while (temporaryListOfNodes.size() != 1) {
            node1 = temporaryListOfNodes.remove(0);
            node2 = temporaryListOfNodes.remove(0);
            Node newNode = new Node(node1.getValue() + node2.getValue(), node1.getWeight() + node2.getWeight(), node1, node2);
            node1.setParent(newNode);
            node2.setParent(newNode);
            temporaryListOfNodes.add(newNode);
            temporaryListOfNodes.sort(Comparator.comparingInt(Node::getWeight));
        }

        return this;
    }

    ResultBuilder createKeysTable() {
        for (Node node : listOfNode
        ) {
            if (node.getLeft() == null && node.getRight() == null) {
                Node currentNode = node;
                ArrayList<Bit> bits = new ArrayList<>();
                while (currentNode.getParent() != null) {
                    if (currentNode.getParent().getLeft() == currentNode) {
                        bits.add(0, ZERO);
                    } else {
                        bits.add(0, ONE);
                    }
                    currentNode = currentNode.getParent();
                }
                tableKey.put(node.getValue(), bits);

            }
        }
        return this;
    }

    ResultBuilder codingFile() {
        for (Integer key : originalDataFromFile
        ) {
            ArrayList<Bit> code = tableKey.get(String.valueOf(key));
            bits.addAll(code);
        }

        return this;
    }

    /*  ResultBuilder setFileName(String fileName) {
          this.filename = fileName;
          return this;
      }
  */
    CompressionResult build() {

        return CompressionResult.createCompressionResult(this);

        //   return null;
    }
}
