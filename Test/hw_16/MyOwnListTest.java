package hw_16;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class MyOwnListTest {
    private MyOwnList<String> list;
    private Collection<String> x;

    @Before
    public void BeforeTests() {
        list = new MyOwnList<>();
        list.add("67");

        list.add("89");

        list.add("1");
        x = new ArrayList<>();
        x.add("4");
        x.add("1");
        x.add("67");
    }

    @Test
    public void AddRemoveSize() {
        //  list = new MyOwnList<>();
        assertEquals(3, list.size);
        list.add("3");
        assertEquals(4, list.size);
        list.remove("2");
        assertEquals(4, list.size);
        list.remove("3");
        list.remove(0);
        assertEquals(2, list.size);


    }

    @Test
    public void isEmpty() {
        list.clear();
        assertTrue(list.isEmpty());
        list.add("uyuy");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void contains() {
        list.add("1");
        list.add("2");
        list.add("5");
        assertTrue(list.contains("2"));
        assertTrue(list.contains("5"));
        assertTrue(list.contains("1"));
        assertFalse(list.contains("4"));

    }


    @Test
    public void toArray() {

        Object[] expectedArray = {"67", "89", "1"};
        assertArrayEquals(expectedArray, list.toArray());
    }


    @Test
    public void containsAllAndAddAll() {

        assertFalse(list.containsAll(x));
        x.remove("4");
        assertTrue(list.containsAll(x));
        list.addAll(x);
        assertEquals(5, list.size);
        assertEquals("89", list.get(1));
        assertEquals("67", list.get(0));
        assertEquals("67", list.get(4));
        list.removeAll(x);
        assertEquals("89", list.get(0));
        assertEquals(1, list.size);

    }


    @Test
    public void removeAll() {
        list.removeAll(x);
        assertEquals(1, list.size);
        //assertNull(list.get(0));

    }

    @Test
    public void retainAll() {
        list.retainAll(x);
        assertEquals(2, list.size);
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(0, list.size);
    }


    @Test
    public void set() {
        list.set(1, "90");
        assertEquals("90", list.get(1));

        assertEquals("1", list.get(2));
        assertEquals(3, list.size);
    }


    @Test
    public void indexOf() {
        assertEquals(1, list.indexOf("89"));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(1, list.lastIndexOf("89"));
    }

    @Test
    public void listIterator() {
        ListIterator<String> li = list.listIterator();
        assertTrue(li.hasNext());
        list.clear();
        li = list.listIterator();
        assertFalse(li.hasNext());
    }


    @Test
    public void subList() {
        //    list.subList(1,2);
        assertEquals(2, list.subList(1, 2).size());
    }
}