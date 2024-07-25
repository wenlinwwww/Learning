package allcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection2 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");

        Iterator<String> iterator = collection.iterator();
        //判断当前位置是否有元素
        while (iterator.hasNext()) {
            //获取元素并移动指针
            String str = iterator.next();
            System.out.println(str);
        }

        // System.out.println(iterator.next()); //NoSuchElementException
        System.out.println(iterator.hasNext());
    }
}
