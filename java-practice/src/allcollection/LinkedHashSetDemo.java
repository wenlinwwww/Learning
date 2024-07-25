package allcollection;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Student s1 = new Student("ww", 23);
        Student s2 = new Student("w", 25);
        Student s3 = new Student("wz", 24);
        Student s4 = new Student("ww", 23);
        LinkedHashSet<Student> s = new LinkedHashSet<>();
        System.out.println(s.add(s1));
        System.out.println(s.add(s3));
        System.out.println(s.add(s2));
        System.out.println(s.add(s4));
        System.out.println(s);
    }

}
