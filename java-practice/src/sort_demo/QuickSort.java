package sort_demo;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("time:" + total);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        int s = start;
        int e = end;
        if (start > end) {
            return;
        }

        int baseNumber = arr[s];
        while (s != e) {
            while (true) {
                if (e <= s || arr[e] < baseNumber) {
                    break;
                }
                e--;
            }

            while (true) {
                if (e <= s || arr[s] > baseNumber) {
                    break;
                }
                s++;
            }
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
        }
        int temp = arr[start];
        arr[start] = arr[s];
        arr[s] = temp;
        //确定基准数左右两边的排序。
        //先找左边的，基准数是index0，任何end是基准数左边一位就是s-1
        quickSort(arr, start, s - 1);
        //找右边的排序，基准书就是s或者e+1，end就是原数组end
        quickSort(arr, e + 1, end);
    }
}
