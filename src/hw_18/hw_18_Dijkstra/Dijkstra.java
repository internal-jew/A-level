package hw_18.hw_18_Dijkstra;

import java.util.ArrayList;
import java.util.Map;


class Dijkstra {
private Graph graph;

    int getDijkstra(Graph graph, String nameFrom, String nameTo) {
     this.graph=graph;
        clearDijkstraMark(graph);
        Vertex startVertex = graph.getVertex(nameFrom);
        startVertex.setDijkstraMark(0);
        Vertex finishVertex = graph.getVertex(nameTo);

        fillDijkstraToConnectVertex(startVertex);

        return finishVertex.getDijkstraMark();
    }

    private void fillDijkstraToConnectVertex(Vertex vertex) {
        vertex.setUsedInDijkstra(true);
        ArrayList<Vertex> nextVertexList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : vertex.getRelation().entrySet()
        ) {
            Vertex relationVertex = graph.getVertex(entry.getKey());
            if (relationVertex.getDijkstraMark() == -1 || vertex.getDijkstraMark() + entry.getValue() < relationVertex.getDijkstraMark()) {
                relationVertex.setDijkstraMark(vertex.getDijkstraMark() + entry.getValue());
                if (nextVertexList.size() == 0) {
                    nextVertexList.add(relationVertex);
                } else {
                    if (!relationVertex.isUsedInDijkstra()) {
                        boolean tempAddVertexToList = false;
                        for (int i = 0; i < nextVertexList.size(); i++) {
                            if (nextVertexList.get(i).getDijkstraMark() > relationVertex.getDijkstraMark()) {
                                nextVertexList.add(i, relationVertex);
                                tempAddVertexToList = true;
                                break;
                            }

                        }
                        if (!tempAddVertexToList) {

                            nextVertexList.add(relationVertex);
                        }

                    }
                }
            }
        }
        while (nextVertexList.size() > 0) {
            fillDijkstraToConnectVertex(nextVertexList.get(0));
            nextVertexList.remove(0);
        }

    }


    private void clearDijkstraMark(Graph graph) {
        for (Vertex v : graph.getSetOfVertex()
        ) {
            v.setDijkstraMark(-1);
            v.setUsedInDijkstra(false);
        }
    }
}
