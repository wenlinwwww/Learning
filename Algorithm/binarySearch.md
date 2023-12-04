# Binary Search 二分搜索

首先这是一个有序数组，然后你要找一个数x，假设数组左边叫L，右边叫R，中间叫Y，如果Y==x，那就return true，如果Y&lt;X, 就砍一半数组，只看剩下的R部分，并将R分成L和R，然后找新的Y；如果Y&gt;X, 就砍一半数组，只看剩下的L部分，并将L分成L和R，然后找新的Y；

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