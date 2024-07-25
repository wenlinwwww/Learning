package allcollection;

import java.util.HashSet;

public class HashSetDemo02 {
    public static void main(String[] args) {
        Student student1 = new Student("ww", 24);
        Student student2 = new Student("w", 26);
        Student student3 = new Student("wz", 25);
        Student student4 = new Student("ww", 24);
        HashSet<Student> students = new HashSet<>();
        System.out.println(students.add(student1)); //true
        System.out.println(students.add(student2)); //true
        System.out.println(students.add(student3)); //true
        System.out.println(students.add(student4)); //false
        System.out.println(students);
    }
}
