package module;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.SortedSet;

public class Node {
    private  String value;
    private  int weight;
    private Node left;
    private Node right;
    private Node parent;

    public void setParent(Node node){
        this.parent=node;
    }
    public Node getParent(){
        return parent;
    }

    public Node(String value, int weight, Node left, Node right) {
        this.value = value;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }
    public Node(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public static Node getNodeByValue(ArrayList<Node> list, String value) throws NullPointerException{
        for (Node node:list
             ) {
            if(node.value.equals(value)){
              return node;
            }

        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value "+value+
                " weight=" + weight +
                '}';
    }
}
