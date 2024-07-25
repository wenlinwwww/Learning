package searchcode;

public class BasicSearch2 {
    public static void main(String[] args) {
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79};
        System.out.println(searchIndex(arr, 79));
        System.out.println(searchIndex(arr, 90));
    }

    public static int searchIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
