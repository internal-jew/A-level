package hw_18;

public class Graph {

    private Node head;

    public Graph() {
    }

    public Graph(Node head) {

        this.head = head;
    }

    public void addElement(final int elementValue) {
        final Node node = new NodeImplementation(elementValue);

        if (head == null) {
            head = node;
        } else {
            head.addElement(node);
        }
    }

    public void deleteElement(int elementValue) {
        final Node node = new NodeImplementation(elementValue);
        if (head == null)
            return;
        head.deleteElement(node);
    }


    @Override
    public String toString() {
        return "Graph{" +
                "head=" + head +
                '}';
    }
}
