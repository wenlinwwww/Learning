package oopshallowcopy;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] data = {1,2,3,4,5,6};
        User user = new User(1, "hello", "pwd123", "gri111", data);
        User user1 = (User) user.clone();
        int[] arr = user.getData();
        arr[0] = 100;
        // to prove clone method in object is shallow copy
        System.out.println(user1);
        System.out.println(user);

    }
}
