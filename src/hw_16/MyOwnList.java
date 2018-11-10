package hw_16;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    //  private Node<T> prev;
    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: 10.11.2018  1
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {

        Node newNode = new Node<T>(t, last, null);
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {


        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
       //See It
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
       //Do It
        Node<T> current = getNode(index);
        for (T element : c) {
            Node<T> addingElement = new Node<T>(element, current.getPrev(), current);
            current.setPrev(addingElement);
            current.getPrev().setNext(addingElement);
           // maybe this line is not to use// current = addingElement;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    //See It
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public T get(int index) {
       //See It

        Node<T> current = getNode(index);
        return current.getElement();

    }

    private Node<T> getNode(int index) {
       // See It
        checkIndex(index);
        int counter = 0;
        Node<T> current = first;
        while (counter != index) {
            counter++;
            current = current.getNext();
        }
        return current;
    }

    private void checkIndex(int index) {
      //See It
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < 0) {
            throw new NegativeArraySizeException();
        }
    }

    @Override
    public T set(int index, T element) {
       //See It
        Node<T> current = getNode(index);
        T prevElement = current.getElement();
        current.setElement(element);
        return prevElement;
    }

    @Override
    public void add(int index, T element) {
        // Do IT
        if (index == size - 1) {
            add(element);
            return;
        }

        Node<T> current = getNode(index);

        Node<T> addingElement = new Node<T>(element, current.getPrev(), current);
        size++;
        current.setPrev(addingElement);
        current.getPrev().setNext(addingElement);
    }

    @Override
    public T remove(int index) {
    //Do it
        getNode(index).getPrev().setNext(getNode(index).getNext());
        getNode(index).getNext().setPrev(getNode(index).getPrev());
        size--;
        return getNode(index).getElement();
    }

    @Override
    public int indexOf(Object o) {
        // See ok
        int counter = 0;
        Node<T> current = first;
        while (current.getElement() != o) {
            counter++;
            current = current.getNext();
            if (counter == size) {
                return -1;
            }
        }
        return counter;
    }

    @Override
    public int lastIndexOf(Object o) {
        // Do It
        int counter = size-1;
        Node<T> current = last;
        while (current.getElement() != o) {
            counter--;
            current = current.getPrev();
            if (counter ==-1) {
                return -1;
            }
        }

        return counter;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
