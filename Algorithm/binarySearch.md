# Binary Search 二分搜索

首先保证这是一个有序数组，然后你要找一个数x，假设数组左边叫L，右边叫R，中间叫Y，如果Y==x，那就return true，如果Y&lt;X, 就砍一半数组，只看剩下的R部分，并将R分成L和R，然后找新的Y；如果Y&gt;X, 就砍一半数组，只看剩下的L部分，并将L分成L和R，然后找新的Y；

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
        int m = (i+j) >>> 1;
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