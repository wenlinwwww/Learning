# Array 数组
## Benefit and limitation of array
### Benefit
- Fast access speed: Arrays allow quick access to elements using indexes.  
存取速度快

### Limitations
- 事先必须知道数组的长度  
Fixed size: The size of the array must be known in advance and cannot be changed dynamically.
- 插入删除元素很慢  
Slow insertion and deletion: Inserting or deleting elements in an array is slow because it may require shifting elements.
- 空间通常是有限制的  
Limited space: The space for an array is often limited and predetermined.
- 需要大块连续的内存块  
Need for a large contiguous memory block: Arrays require a large, continuous block of memory, which can be a limitation.
- 插入删除元素的效率很低  
Low efficiency for insertion and deletion: The efficiency of inserting and deleting elements in an array is generally low, especially if the array is large.

## Examples
- [283 Move Zeroes (Easy)](https://leetcode.com/problems/move-zeroes/description/)
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
```java
public void moveZeroes(int[] nums) {
    int idx = 0;
    for (int num : nums) {
        if (num != 0) {
            nums[idx++] = num;
            // this is equal to nums[idx] = num; idx++;
        }
    }
    while (idx < nums.length) {
        nums[idx++] = 0;
    }
}
```


# Matrix 矩阵

## Examples
- 566 Reshape the Matrix  

Input:  
nums =
[[1,2],
 [3,4]]
r = 1, c = 4

Output:  
[[1,2,3,4]]

Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

```java
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] reshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapedNums[i][j] = mat[index / n][index % n];
                index++;
            }
        }
        return reshapedNums;
    }
```