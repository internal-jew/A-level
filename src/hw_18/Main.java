package hw_18;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
/*
        graph.addElement(33);
        graph.addElement(5);
        graph.addElement(35);
        graph.addElement(1);
        graph.addElement(4);
        graph.addElement(20);
        graph.addElement(99);
        graph.addElement(17);
        graph.addElement(31);

        graph.deleteElement(5);
*/


        graph.addElement(8);
        graph.addElement(4);
        graph.addElement(7);
        graph.addElement(5);
        graph.addElement(12);
        graph.addElement(9);
        graph.addElement(2);

        graph.addElement(10);
        graph.addElement(14);
        graph.addElement(3);


        System.out.println(graph);
        graph.deleteElement(4);
        System.out.println(graph);

    }
}
