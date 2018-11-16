package hw_18;

public class NodeImplementation implements Node {
    private Node right;
    private Node left;
    private Node parent;
    private int value;




    public NodeImplementation(int value) {
        this.value = value;
    }

    @Override
    public void addElement(Node node) {
        if (node.getValue() == this.value) return;
        if (node.getValue() > this.value) {
            if (this.right != null) {
                this.right.addElement(node);
            } else {
                this.right = node;
                node.setParent(this);
            }
        } else {
            if (this.left != null) {
                this.left.addElement(node);
            } else {
                this.left = node;
                node.setParent(this);
            }
        }
    }

    @Override
    public void setParent(Node node) {

        this.parent = node;
    }

    @Override
    public void deleteElement(Node node) {
        if (node.getValue() == this.value) {
            if (right == null && left == null) {
                parent.deleteBranch(this);
                return;
            }
            if (right == null) {
                parent.deleteBranch(this);
                parent.addElement(left);
                return;
            }
            if (left == null) {
                parent.deleteBranch(this);
                parent.addElement(right);
                return;
            }
            Node newNode = right.getMin();
            right.deleteElement(newNode);
            newNode.setParent(this.parent);
            newNode.addElement(left);
            newNode.addElement(right);
            parent.deleteBranch(this);
            parent.addElement(newNode);
        } else {
            if (node.getValue() > this.value) {
                if (right != null) {
                    right.deleteElement(node);
                }
            } else {
                if (left != null) {
                    left.deleteElement(node);
                }
            }
        }

    }

    @Override
    public Node getMin() {
        if (left == null) return this;
        return left.getMin();
    }

    @Override
    public Node getMax() {
        if (right == null) return this;
        return right.getMax();
    }

    @Override
    public void deleteBranch(Node node) {
        if (left == node) {
            left = null;
        } else {
            right = null;
        }
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NodeImplementation{" +
                "value=" + value +
                ",right=" + right +
                ", left=" + left +
                '}';
    }

}