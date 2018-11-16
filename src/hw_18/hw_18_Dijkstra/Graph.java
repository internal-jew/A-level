package hw_18.hw_18_Dijkstra;

import java.util.HashSet;

public class Graph {
    private HashSet<Vertex> graph = new HashSet<>();

    void addVertex(String name) {
        Vertex vertex = new Vertex(name);
        graph.add(vertex);
    }

    void addConnection(String nameFrom, String nameTo, int weight, boolean isOriented) {
        if (!isOriented) {
            getVertex(nameTo).addConnection(this, getVertex(nameFrom), weight);
        }
        getVertex(nameFrom).addConnection(this, getVertex(nameTo), weight);

    }

    int getDijkstra(String nameFrom, String nameTo) {
        return new Dijkstra().getDijkstra(this, nameFrom, nameTo);
    }


    Vertex getVertex(String name) throws NullPointerException {
        for (Vertex v : graph
        ) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    HashSet<Vertex> getSetOfVertex() {
        return graph;
    }

    @Override
    public String toString() {
        return "Graph: " + graph;
    }
}
