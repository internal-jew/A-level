package hw_18;

public interface Node {
    Node getRight();

    Node getLeft();

    Node getParent();

    int getValue();

    void setParent(Node node);

    void addElement(Node node);

    void deleteBranch(Node node);

    void deleteElement(Node node);

    Node getMin();

    Node getMax();
}
