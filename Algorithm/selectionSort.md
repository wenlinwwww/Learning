## Selection sort 选择排序
### 基本原理
从0索引开始，拿着每一个索引上的元素跟后买呢元素依次比较，小的放前面，大的放后面，以此类推。
（和冒泡排序差不多，只不过冒泡先找最大的（左右左右交换，直到最大的到最右边），选择先找最小的（从第一个索引和后面一一比较，再从第二个索引后面一一比较，先找到0索引最小值））
```java
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,4,5,3,1};
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```

### summary
- 时间复杂度为 O(n²)。
- 简单，但效率低于更复杂的算法。