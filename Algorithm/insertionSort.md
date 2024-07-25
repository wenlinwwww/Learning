## Insertion Sort 插入排序
### 基本定义
将0索引的元素到n索引的元素看作是有序的，把n+1索引的元素到最后一个当成是无序的。遍历无序的数据，将遍历到的元素插入有序序列中适当的位置，如遇到相同元素，插在后面。
```java
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 找到无序的是从那一组开始
        int start = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i+1]) {
                start = i + 1;
                break;
            }
        }
        for (int i = start; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
```
### sumamry
- 时间复杂度为 O(n²)。
- 对于较小的数据集或基本有序的数据效率较高。