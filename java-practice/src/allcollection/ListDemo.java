package allcollection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //原来索引的元素依次往后移
        list.add(1, "qqq");
        System.out.println(list.remove(0)); //aaa

        System.out.println(list);
        System.out.println(list.set(1, "aaa"));
        System.out.println(list.get(0));
        System.out.println(list);

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String str = listIterator.next();
            if ("bbb".equals(str)) {
                listIterator.add("qqq");
            }
        }
    }
}
