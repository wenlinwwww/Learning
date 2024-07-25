## Bubble sort 冒泡排序
### 基本原理
相邻元素两两比较，大的放右边，小的放左边；  
第一轮循环结束，最大值已经找到，到了数组最左边；  
第二轮循环只要再剩余的元素中找到最大值就行；  
第二轮循环结束，次大值已经确定，第三轮循环继续再剩余元素中循环。

```java
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
```
### summary
- 时间复杂度为 O(n²)。
- 简单但效率较低。