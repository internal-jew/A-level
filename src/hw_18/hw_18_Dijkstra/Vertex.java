package hw_18.hw_18_Dijkstra;

import java.util.HashMap;

public class Vertex {
    private String name;
    private HashMap<String, Integer> relation = new HashMap<>();
    private boolean isUsedInDijkstra;

    private int dijkstraMark;

    boolean isUsedInDijkstra() {
        return isUsedInDijkstra;
    }

    void setUsedInDijkstra(boolean usedInDijkstra) {
        isUsedInDijkstra = usedInDijkstra;
    }

    HashMap<String, Integer> getRelation() {
        return relation;
    }

    Vertex(String name) {
        this.name = name;
    }

    void addConnection(Graph graph, Vertex vertex, int weight) {
        for (Vertex v : graph.getSetOfVertex()
        ) {
            if (v.equals(vertex)) {
                this.relation.put(vertex.name, weight);
                return;
            }
        }
    }


    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Vertex: " + name + "\n" + "Connection: to " + relation + "\n";
    }

    void setDijkstraMark(int dijkstraMark) {
        this.dijkstraMark = dijkstraMark;
    }

    int getDijkstraMark() {
        return dijkstraMark;
    }

}
