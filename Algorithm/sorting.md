数组交换两个数：
让temp等于第一个数，第一个数等于换的的第二个数，第二个数等于temp  
code:  
```java
	// 数组中交换i和j位置的数
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
```

Selection sort - 选择排序一句话：i~n-1范围上，找到最小值并放在i位置，然后i+1~n-1范围上继续   
（头和最小换，确定最小）   
e.g.  
```
5 3 1 2 4
1 3 5 2 4 (找0-4最小值，找到1，和index0的数交换)
1 2 5 3 4（找1-4最小值，找到2，和index1的数交换）
1 2 3 5 4（找2-4最小值，找到3，和index2的数交换）
1 2 3 4 5（找3-4最小值，找到4，和index3的数交换）
```
code:  
```java
	// 选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

        // 1~ n-1,找到最小值，放到i位置
        //假设minIndex现在就是最小值
		for (int minIndex, i = 0; i < arr.length - 1; i++) {
			minIndex = i;
            //另一个指针，用来对比当前index的值是否比minindex值小，如何小，minIndex就变为现在的index
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
```

   
Bubble sort - 冒泡排序一句话：0~i范围上，相邻位置较大的数滚下去，最大值最终来到i位置，然后0~i-1范围上继续  
（两两对比，确认最后一位）
```
round1:
5 3 4 1 2
3 5 4 1 2 (index0和1的值对比，谁大谁往后，5>3)
3 4 5 1 2（index1和2的值对比，谁大谁往后，5>4）
3 4 1 5 2（index2和3的值对比，谁大谁往后，5>1）
3 4 1 2 5（index3和4的值对比，谁大谁往后，5>2，此时确定了index最大的值）

round2:
3 4 1 2 5
3 4 1 2 5（index0和1的值对比，谁大谁往后，3<4）
3 1 4 2 5（index1和2的值对比，谁大谁往后，4>1）
3 1 2 4 5（index3和4的值对比，谁大谁往后，4>2, 此时确定了index倒数第二大的值）

round3:
3 1 2 4 5
1 3 2 4 5（index0和1的值对比，谁大谁往后，3>1）
1 2 3 4 5（index1和2的值对比，谁大谁往后，3>2, 此时倒数第三个index的值确定了）

round4:
1 2 3 4 5 （index0和1的值对比，谁大谁往后，1<2, 结束）
```

```java
	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
```


（最有用的）Insertion sort - 插入排序一句话：0~i范围上已经有序，新来的数从右到左滑到不再小的位置插入，然后继续 
（0-1，0-2，0-n-1，一坨坨慢慢排序） 
```
round1：将index0~1排有序
5 3 4 1 2
3 5 4 1 2 （对比index1和1，5>3，交换）

round2：将index0~2排有序（因为0-1已经有序，所以从2开始和前面对比）
3 5 4 1 2 
3 4 5 1 2（对比index2和1，4<5，交换）
3 4 5 1 2（对比index1和0，4>3，不交换，此时index0-2有序）

round3: 将index0~3排有序（因为0-2已经有序，所以从3开始和前面对比）
3 4 5 1 2
3 4 1 5 2（对比index3和2，1<5，交换）
3 1 4 5 2（对比index2和1，1<4，交换）
1 3 4 5 2（对比index1和0，1<3，交换, 此时index0-3有序）

round4: 将index0~4排有序（因为0-2已经有序，所以从3开始和前面对比）
1 3 4 5 2
1 3 4 2 5 （对比index4和3，2<5，交换）
1 3 2 4 5 （对比index3和2，2<4，交换）
1 2 3 4 5 （对比index2和1，2<3，交换）
1 3 2 4 5 （对比index1和0，2>1，不交换，此时0-4有序）
```
```java
// 插入排序
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
        //外循环就是看0-1，0-2，0-3，0-4，0-n-1有序，i就相当于n
		for (int i = 1; i < arr.length; i++) {
            //新来的数是i，但0-i-1有序了，向左看；此处j是当前数前一个位置，j+1是当前数位置，如果前一个数比当前数小，或者此时j=-1（也就是小于0，说明当前数左边已经没有数了），就停止前挪
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}
```