package allcollection;

public class HashSetDemo01 {

    public static void main(String[] args) {
        Student student1 = new Student("ww", 24);
        Student student2 = new Student("ww", 24);
        System.out.println(student2.hashCode()); //821270929
        System.out.println(student1.hashCode()); //1160460865
        // after override hashcode, output is 119033

        // hash collapse
        System.out.println("abc".hashCode()); // 96354
        System.out.println("acD".hashCode()); // 96354
    }
}
