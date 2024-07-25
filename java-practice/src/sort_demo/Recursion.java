package sort_demo;

public class Recursion {

    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(multiply(5));
        System.out.println(sum);
    }
    private static int sum(int i) {

        if (i == 1) {
            return 1;
        }
        return i + sum(i - 1);
    }

    private static int multiply(int num) {
        if (num == 1) {
            return 1;
        }
        return num * multiply(num - 1);
    }
}
