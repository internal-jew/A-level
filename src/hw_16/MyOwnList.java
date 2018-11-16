package hw_16;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    //private Node<T> prev;
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
        // Do it
        Node<T> current = first;
        while (current != null) {
            if (current.getElement() == o) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        class MyOwnIterator implements java.util.Iterator  {
            private Node activeNode = null;

            @Override
            public boolean hasNext() {
                if (activeNode == null && size > 0) {
                    return true;
                }
                return (activeNode != null ? activeNode.getNext() : null) != null;
            }

            @Override
            public Object next() {
                if (activeNode == null && size > 0) {
                    activeNode = first;
                    return activeNode.getElement();
                }


                return activeNode != null ? activeNode.getNext().getElement() : null;

            }

        }
            Iterator<T> it=new MyOwnIterator();
        return (Iterator<T>)new MyOwnIterator();
    }

    @Override
    public Object[] toArray() {
        //Do it
        Object[] result = new Object[size];
        Node<T> current = first;
        int counter = 0;
        while (current != null) {
            result[counter++] = current.getElement();
            current = current.getNext();
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean add(T t) {

        Node<T> newNode = new Node<>(t, last, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);

            last = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        while (remove(indexOf(o)) != null) {
            remove(indexOf(o));
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c
        ) {
            if (!contains(element)) {
                return false;
            }

        }
        return true;
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
            Node<T> addingElement = new Node<>(element, current.getPrev(), current);
            current.setPrev(addingElement);
            current.getPrev().setNext(addingElement);
            // maybe this line is not to use// current = addingElement;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for (Object element : c
        ) {
            remove(element);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        //Do it
        MyOwnList<T> listToDelete = new MyOwnList<>();
        Node<T> current = first;
        boolean mustBeDelete = true;

        while (current != null) {
            for (Object element : c
            ) {
                if (current.getElement() == element) {
                    mustBeDelete = false;
                    break;
                }
            }
            if (mustBeDelete) {
                listToDelete.add(current.getElement());
            }
            mustBeDelete = true;
            current = current.getNext();
        }
        for (
                T element : listToDelete
        ) {
            remove(element);
        }
        return true;
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
        if (index == size - 1 || size == 0) {
            add(element);
            return;
        }

        Node<T> current = getNode(index);

        Node<T> addingElement = new Node<>(element, current.getPrev(), current);
        size++;
        current.setPrev(addingElement);
        current.getPrev().setNext(addingElement);
    }

    @Override
    public T remove(int index) {
        //Do it
        if (index < 0) {
            return null;
        }
        Node<T> current = getNode(index);
        Node<T> prevCurrent = current.getPrev();
        Node<T> nextCurrent = current.getNext();

        if (index > 0 && index < size - 1) {

            prevCurrent.setNext(nextCurrent);
            nextCurrent.setPrev(prevCurrent);
            //getNode(index).getPrev().setNext(getNode(index).getNext());
        }

        if (index == 0 && size > 1) {
            first = nextCurrent;
            nextCurrent.setPrev(null);
        }
        if (index == 0 && size == 1) {
            clear();
        }

        if (index == size - 1) {
            last = prevCurrent;
            prevCurrent.setNext(null);
        }

        //getNode(index).getNext().setPrev(getNode(index).getPrev());
        if (size > 0) {
            size--;
        }
        return current.getElement();
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
        int counter = size - 1;
        Node<T> current = last;
        while (current.getElement() != o) {
            counter--;
            current = current.getPrev();
            if (counter == -1) {
                return -1;
            }
        }

        return counter;
    }

    @Override
    public ListIterator<T> listIterator() {
        //ListIterator<T> listIterator = new ListIterator<T>() {
        class MyOwnListIterator implements ListIterator {
            private Node<T> activeNode = first;
            private int index = 0;


            @Override
            public boolean hasNext() {

                return (activeNode != last);
            }

            @Override
            public T next() throws IndexOutOfBoundsException {
                activeNode = activeNode.getNext();
                index++;
                return activeNode.getPrev().getElement();
            }


            @Override
            public boolean hasPrevious() {
                return (activeNode != first);
            }

            @Override
            public T previous() throws IndexOutOfBoundsException {
                activeNode = activeNode.getPrev();
                index--;
                return activeNode.getPrev().getElement();
            }

            @Override
            public int nextIndex() throws IndexOutOfBoundsException {


                return index;
            }

            @Override
            public int previousIndex() throws IndexOutOfBoundsException {
                return index - 1;
            }

            @Override
            public void remove() {
                MyOwnList.this.remove(index - 1);
            }

            @Override
            public void set(Object o) {
                MyOwnList.this.set(index - 1, (T) o);
            }

            @Override
            public void add(Object o) {

                MyOwnList.this.add((T)o);
            }
        }
        ;
        //throw new UnsupportedOperationException();
        return new MyOwnListIterator();
   // return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //throw new UnsupportedOperationException();
        ListIterator listIterator = listIterator();
        for (int i = 0; i <= index; i++) {
            listIterator.next();
        }
        //listIterator().nextIndex();
        return listIterator;

    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new MyOwnList<>();
        Node<T> current = getNode(fromIndex);
        for (int i = 0; i <= toIndex - fromIndex; i++) {
            subList.add(current.getElement());
            current = current.getNext();
        }
        return subList;
    }
}
