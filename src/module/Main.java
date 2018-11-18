package module;

import module.Utils.Scanner;

public class Main {
    public static void main(String[] args) {

        CompressionResult result = CompressionResult
                .createBuilder()
                .readDataFromFile(Scanner.getFileNameFromConsole())
                .createFrequencyDictionary()
                .createTreeNodes()
                .createKeysTable()
                .codingFile()
                .build();
        //try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
   /*     try (FileInputStream inputStream = new FileInputStream("d:\\Test.rtf")
        ) {
            // FileInputStream inputStream=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            //    ArrayList<Integer> listData = new ArrayList<>();
            //PriorityQueue<Integer>listData=new PriorityQueue<>();
            ArrayList<Integer> listData = new ArrayList<>();


            while (inputStream.available() > 0) {
         //   while (inputStream.re > 0) {
                listData.add(inputStream.read());

            }*/

        //  System.out.println(Scanner.getFileNameFromConsole());

        //   System.exit(0);

        //  ArrayList<Integer> listData=builder.readDataFromFile(Scanner.getFileNameFromConsole());
        //  HashMap<Integer, Integer> dictionary = new HashMap<>();
        //    TreeMap<Integer,Integer> dictionary=new TreeMap<>();
        //  PriorityQueue<Node>listNodes=new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        //     TreeSet<Node> listNodes = new TreeSet<>(Comparator.comparingInt(Node::getValue));
        //    TreeSet<Node> listNodes1 = new TreeSet<>(Comparator.comparingInt(Node::getWeight));
        //      TreeSet<Node> listNodes = new TreeSet<>();
        //  ArrayList<Node> listNodes = new ArrayList<>();

        /*    for (Integer integer : listData
            ) {
                if (Node.getNodeByValue(listNodes, String.valueOf(integer)) != null) {
                    Node.getNodeByValue(listNodes, String.valueOf(integer)).setWeight(Node.getNodeByValue(listNodes, String.valueOf(integer)).getWeight() + 1);
                } else {
                    listNodes.add(new Node(String.valueOf(integer), 1));
                }*/

        //    listNodes1.addAll(listNodes);


            /*
            if (dictionary.containsKey(integer)) {
                    dictionary.put(integer, dictionary.get(integer) + 1);
                } else {
                    dictionary.put(integer, 1);
                }
                */
 //   }
    //    System.out.println(dictionary);


    //  SortedList<Node> listNodes=new SortedList<>();
    //listNodes.add()
       /*     while (dictionary.values().size()>1){

            }

            Map.Entry<Integer,Integer> en=dictionary.ceilingEntry(0);
            System.out.println(dictionary.ceilingEntry(0));
       dictionary.remove(en.getKey(),en.getValue());
            System.out.println(dictionary.ceilingEntry(0));
*/
    //    listNodes.sort(Comparator.comparingInt(Node::getWeight));

    //  ArrayList<Node> restoreListNode = new ArrayList<>();
    //   restoreListNode.addAll(listNodes);
    //         System.out.println(listNodes);
    //         System.out.println(restoreListNode);

    // int countOfNodesInTree=listNodes.size()*2-1;
     /*       Node node1, node2;
            while (listNodes.size() != 1) {
                node1 = listNodes.remove(0);
                node2 = listNodes.remove(0);
                Node newNode = new Node(node1.getValue() + node2.getValue(), node1.getWeight() + node2.getWeight(), node1, node2);
                node1.setParent(newNode);
                node2.setParent(newNode);
                listNodes.add(newNode);
                listNodes.sort(Comparator.comparingInt(Node::getWeight));
            }
*/

    //   System.out.println(listNodes);

        /*    TreeMap<String, String> tableKey = new TreeMap<>();
            //  StringBuilder code = new StringBuilder();
            for (Node node : restoreListNode
            ) {
                //Node currentNode=node;
                Node currentNode = node;
                StringBuilder code = new StringBuilder();
                while (currentNode.getParent() != null) {


                    if (currentNode.getParent().getLeft() == currentNode) {
                        //    builder.addBit(ZERO);
                        code.append("0");
                    } else {
                        //   builder.addBit(ONE);
                        code.append("1");
                    }
                    currentNode = currentNode.getParent();
                }
                tableKey.put(node.getValue(), code.reverse().toString());

            }
            //  Node.getNodeByValue()

            System.out.println(tableKey);*/

    /*
                for(
        Integer integer :listData
                )

        {
            String code = tableKey.get(String.valueOf(integer));
            for (char bit : code.toCharArray()
            ) {
                builder.addBit((bit));
            }

        }
    */
    //  CompressionResult result = builder.setFileName("D:\\Test.ccc").build();
    //builder.build()

    //          System.out.println(result.getBytes());


    //Расшифровка
 /*   StringBuilder code = new StringBuilder();
    ArrayList<Integer> decoderList = new ArrayList<>();
            for(
    char bit :result.getBytes()
            )

    {
        //  code.append(bit);

        code.append(bit);

        if (tableKey.containsValue(code.toString())) {
            for (Map.Entry entry : tableKey.entrySet()
            ) {
                if (entry.getValue().equals(code.toString())) {
                    decoderList.add(Integer.valueOf(entry.getKey().toString()));
                    code.delete(0, code.length());

                }
            }


        }
//code.reverse();
    }
            System.out.println(decoderList);


      /*      FileOutputStream fileOutputStream=new FileOutputStream("d:\\test.ccc");
            byte[] buffer=result.getBytes().toArray();
            fileOutputStream.write(result.getBytes(),0,result.getBytes().size());
            */


    //     } catch (IOException e) {
    //          System.out.println("Problem with reading file");
    //     }


    //      Bit[] bits = new Bit[]{ONE, ZERO, ONE};

    //  Bit[]bits=doHaffmanLogic();


    //       resultBuilder builder = createBuilder();
       /* for (Bit bit : ) {
            builder.addBit(bit);
        }
        builder.setFileName("uytuyt");
        CompressionResult result = builder.build();
        //  writeToFile(result);*/

}


    public static String getFileNameFromConsole() {
        //  Scanner scanner=new Scanner(System.in);
        //  return new Scanner(System.in).next();
        return "d:\\Test.rtf";
    }

}
