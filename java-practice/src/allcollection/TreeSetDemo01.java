package allcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo01 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(4);
        ts.add(5);
        ts.add(1);
        ts.add(9);
        System.out.println(ts); //[1, 4, 5, 9]

        for (int i : ts) {
            System.out.println(i);
        }
        ts.forEach(System.out::println);

        System.out.println("--------------demo-2------------");
        // demo 2
        StudentDemo studentDemo1 = new StudentDemo("lee", 23);
        StudentDemo studentDemo2 = new StudentDemo("li", 21);
        StudentDemo studentDemo3 = new StudentDemo("apple", 25);
        TreeSet<StudentDemo> treeSet = new TreeSet<>();
        treeSet.add(studentDemo1);
        treeSet.add(studentDemo2);
        treeSet.add(studentDemo3);
        System.out.println(treeSet);


        System.out.println("---------demo-3---------");
        //demo 3
        /* o1当前要添加的元素
         * o2当前已经存在元素
         */
        TreeSet<String> ts2 = new TreeSet<>((o1, o2) -> {
            int result = o1.length() - o2.length();
            result = result == 0 ? o1.compareTo(o2) : result;
            return result;
        });
        ts2.add("c");
        ts2.add("ab");
        ts2.add("df");
        ts2.add("qwer");
        System.out.println(ts2);
    }
}
