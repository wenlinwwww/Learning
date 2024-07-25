package sort_demo;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,5,3,1};
        // n个数字，循环n-1轮
        //-1为了防止越界
        //-i提高效率
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - i; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
