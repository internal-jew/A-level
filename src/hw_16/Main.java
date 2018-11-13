package hw_16;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new MyOwnList<>();
        modify(list);

    }

    private static void modify(List<String> list) {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.get(2));
        list.remove("3");
        System.out.println(list.get(2));

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
