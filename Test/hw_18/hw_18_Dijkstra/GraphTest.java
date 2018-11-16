package hw_18.hw_18_Dijkstra;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GraphTest {
    private Graph graph;
    private String from;
    private String to;
    private int dijkstra;


    @Before
    public void before() {
        graph = new Graph();

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
    }

    public GraphTest(String from, String to, int dijkstra) {
        this.from = from;
        this.to = to;
        this.dijkstra = dijkstra;
    }


    @Parameterized.Parameters(name = "{index}: dijkstra from {0} to {1} = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {"0", "1", 5},
                {"1", "5", 9},
                {"0", "2", 8},
                {"0", "3", 17},
                {"0", "4", 16},
                {"0", "5", 12},
                {"0", "6", 10},

        });
    }

    @Test
    public void paramTest() {
        assertEquals(dijkstra, graph.getDijkstra(from, to));
    }
}