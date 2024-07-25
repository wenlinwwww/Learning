package allcollection;

public class StudentDemo implements Comparable<StudentDemo> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(StudentDemo o) {
        // implement sort rule in here
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "StudentDemo{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
