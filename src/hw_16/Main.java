package hw_16;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

        public static void main(String[] args) {
           List list = new MyOwnList();
            modify(list);

        }

        private static void modify(List list) {
            list.add(new Object());
            list.get(0);

        /*    Iterator i = new Iterator() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    return null;
                }
            };*/
        }

    }
