package searchcode;

public class BasicSearch {
    public static void main(String[] args) {
        // start with index 0, search it one by one.
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79};
        System.out.println(search(arr, 150));
        System.out.println(search(arr, 7));
    }

    public static boolean search(int[] arr, int num) {
        for (int j : arr) {
            if (j == num) {
                return true;
            }
        }
        return false;
    }

}
