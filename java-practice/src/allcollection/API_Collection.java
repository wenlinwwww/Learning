package allcollection;

import java.util.ArrayList;
import java.util.Collection;

public class API_Collection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        //如果是set，重复添加会返回false
        collection.add("aa");
        System.out.println(collection);

        collection.clear();
        System.out.println(collection);

        //不能通过index删除，只能通过对象删除
        //删除成功返回true，失败返回false
        System.out.println(collection.remove("aa")); //false
        collection.add("bbb");
        collection.add("ccc");
        System.out.println(collection.remove("bbb")); //true

        System.out.println(collection.contains("ccc"));//true
        System.out.println(collection.contains("bbb"));//false

        System.out.println(collection.isEmpty());//false
        System.out.println(collection.size()); //1

    }
}
