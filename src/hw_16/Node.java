package hw_16;

class Node<T> {
     Node(T element, Node<T> prev, Node<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    private T element;
    private Node<T> prev;
    private Node<T> next;

    T getElement() {
        return element;
    }
    void setElement(T element) {
        this.element = element;
    }

Node<T> getPrev() {
        return prev;
    }

   void setPrev(Node<T> prev) {
        this.prev = prev;
    }

   Node<T> getNext() {
        return next;
    }

void setNext(Node<T> next) {
        this.next = next;
    }
}
