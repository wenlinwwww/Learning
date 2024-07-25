package allcollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        boolean r1 = s.add("233");
        boolean r2 = s.add("233");// 重复了的只会出现一次
        boolean r3 = s.add("322");
        System.out.println(s);

        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
        for (String string : s) {
            System.out.println(string);
        }
        s.forEach(System.out::println);
    }
}
