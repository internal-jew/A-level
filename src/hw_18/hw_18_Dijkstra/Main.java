package hw_18.hw_18_Dijkstra;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addConnection("0", "1", 5, false);
        graph.addConnection("0", "2", 8, true);
        graph.addConnection("1", "3", 12, false);
        graph.addConnection("1", "5", 9, false);
        graph.addConnection("2", "5", 4, false);
        graph.addConnection("2", "4", 8, false);
        graph.addConnection("2", "6", 2, false);
        graph.addConnection("3", "5", 6, false);
        graph.addConnection("3", "4", 3, false);
        graph.addConnection("4", "6", 7, false);


        System.out.println(graph.getDijkstra("0", "1"));
        System.out.println(graph.getDijkstra("1", "5"));


        System.out.println(graph.getDijkstra("0", "2"));
        System.out.println(graph.getDijkstra("0", "3"));
        System.out.println(graph.getDijkstra("0", "4"));
        System.out.println(graph.getDijkstra("0", "5"));
        System.out.println(graph.getDijkstra("0", "6"));
    }


}
