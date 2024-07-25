# Binary Search 二分搜索

首先保证这是一个**有序数组**，然后你要找一个数x，假设数组左边叫L，右边叫R，中间叫Y，如果Y==x，那就return true，如果Y&lt;X, 就砍一半数组，只看剩下的R部分，并将R分成L和R，然后找新的Y；如果Y&gt;X, 就砍一半数组，只看剩下的L部分，并将L分成L和R，然后找新的Y；

```java
// 保证arr有序，才能用这个方法
	public static boolean exist(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int l = 0, r = arr.length - 1, m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (arr[m] == num) {
				return true;
			} else if (arr[m] > num) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return false;
	}
```

#### summary of binary search
前提条件：数组中的数据必须事有序的
核心思想：每次排除一半的数据，查询数据的性能明显提升
leetcode：34，35，704

过程：
1. left和right表示当前要查找的范围  
2. mid是在left和right中间的  
3. 如果要查找的元素再mid的左边，缩小范围时，left不变，right等于right-1  
4. 如果要查找的元素再mid的右边，缩小范围时，right不变，left等于left-1  
例子：int[] arr = {7,23,79,81,103,127，131，147}，查找79  
首先left_index是0，right_index是length-1；计算mid = (left+right)/2，找到mid-1对应值（79）并和79对比，相等，结束循环 

代码：
```java
    public static int binarySearch(int[] arr, int num) {
        int left_index = 0;
        int right_index = arr.length - 1;
        while (left_index <= right_index) {
            int mid = (left_index + right_index)/2;
            if (num < arr[mid]) {
                right_index = mid - 1;
            } else if (num > arr[mid]){
                left_index = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
```

优化版代码：
```java
public static int binarySearch(int[] a, int num) {
    int i = 0, j = a.length - 1;
    while(i <= j) {
        int m = (i+j) >>> 1; //或者写成 left + (right - left) / 2
        if (num < a[m]) {
            j = mid - 1;
        } else if (num > a[m]) {
            i = mid + 1;
        } else {
            return mid
        }
    }
    //如果要将某个不在数据的数据按顺序插入，那就return left就行。
    return -1;
}
```

ps：其实java里面就有这个算法，叫Arrays.binarySearch

### why using left + (right - left) / 2 instaed of using (left + right) / 2
There are two common ways to calculate the midpoint in binary search:

mid = (left + right) / 2  
mid = left + (right - left) / 2  
The first method calculates the midpoint by adding the lower and upper bounds of the interval and then dividing by two. The second method calculates the midpoint by adding the lower bound to half the length of the interval.

The second method, mid = left + (right - left) / 2, is considered faster and more accurate than the first method, mid = (left + right) / 2, because it reduces the risk of integer overflow.

Integer overflow occurs when the result of an arithmetic operation exceeds the range of representable values for the data type. In Java, the range of integer values is -2^31 to 2^31-1 for the int data type. If the sum of i and n exceeds this range, the result will be incorrect, leading to a bug in our code.

The second method, mid = left + (right - left) / 2, avoids this problem by computing the difference between n and i first, which is always less than or equal to n. Then, we add this difference to i, which is guaranteed to be less than or equal to 2^31-1, ensuring that the result is always within the range of representable values.

Therefore, using the second method to calculate the midpoint is considered faster and more accurate than the first method, especially when working with large values of left and right that are close to the upper bound of the int data type.

### summary
数组必须要是有序的
当包括区间右边数的时候：


### Examples
[35.search insert position](https://leetcode.com/problems/search-insert-position/description/)

time complexity: O(log n)  
space complexity: O(1)  
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left;
    }
}
```

