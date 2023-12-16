### 数组交换两个数：
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

### SelectionSort - 选择排序一句话：i~n-1范围上，找到最小值并放在i位置，然后i+1~n-1范围上继续   
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

#### summary of selection sort
每轮选择当前位置，开始找出后面的较小值与该位置交换  

过程： 
```java
int[] arr = {5,1,3,2};
第一轮：5和1比，5大，5和1交换
1，5，3，2
第一轮：1和3比，1小，不交换
1，5，3，2
第一轮：1和2比，1小，不交换
1，5，3，2

第二轮：5和3比，5大，5和3交换
1，3，5，2
第二轮：3和2比，3大，3和2交换
1，2，5，3

第三轮：5和3比，5大，5和3交换
1，2，3，5
```

```
i（第几轮）     比较位(j)    次数规律
0              1 2 3        3次
1              2 3          2次
2              3            1次
```

代码：
```java
for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
```

优化版代码：
```java
        int[] arr = {5,1,3,2};
        for (int i = 0; i < arr.length - 1; i++) {
            // 假设当前元素是最小的
            int minIndex = i;

            // 在未排序部分查找最小元素的索引
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = i;
                }
            }
            // 交换当前元素与最小元素
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
```

   
### BubbleSort - 冒泡排序一句话：0~i范围上，相邻位置较大的数滚下去，最大值最终来到i位置，然后0~i-1范围上继续（两两对比，确认最后一位）
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

#### summary of bubble sort 
每次从数组中找到最大值放在数组的后面去。

规则：
1. 相邻的元素两个比较，大的放右边，小的放左边
2. 第一轮循环结束，最大值已找到，在数组最右边（第一轮比较完毕之后，最大值已确定，第二轮可以少循环一次，以此类推）
3. 如果数据中有n个数据，总共我们要执行n-1轮代码就行

过程：  
```java
int[] arr = {5,2,3,1};
第一轮：对比第一个第二个，5比2大，5和2交换位置
2,5,3,1
第一轮：对比5和3，还是5大，5和3交换位置
2，3，5，1
第一轮：对比5和1，还是5大，5和1交换位置
2，3，1，5

第二轮：对比2和3，2小，不交换
2，3，1，5
第二轮：对比3和1，3大，交换3和1
2，1，3，5
第二轮：对比3和5，3小，不交换

第三轮：对比2和1，2大，交换2和1
1，2，3，5
第三轮：对比2和3，2小，不交换
1，2，3，5
第三轮：对比3和5，3小，不交换
1，2，3，5
```

步骤分析：
```
i（第几轮）     比较位(j)    次数规律：数组的长度-i-1
0              0 1 2        3次
1              0 1          2次
2              0            1次

若当前位置数值大于后一个位置的，就交换数据
```

代码：
```java
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
```


### （最有用的）InsertionSort - 插入排序一句话：0~i范围上已经有序，新来的数从右到左滑到不再小的位置插入，然后继续 
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


#### summary of insetion sort
将0索引的元素到N索引的元素看做是有序的，把N+1索引的元素到最后一个当成是无序的。

遍历无序的数据，将遍历到的元素插入有序序列中适当的位置，如遇到相同数据，插在后面。

N的范围：0~最大索引

代码：
```java
public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // 将 arr[j] 大于 key 的元素右移
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 插入 key 到正确的位置
            arr[j + 1] = key;
        }
    }
```

### 快速排序(Quick sort)

步骤：
1. 从数列中挑出一个元素，一般都是左边第一个数字，称为 "基准数";
2. 创建两个指针（start和end），一个从前往后走，一个从后往前走。
3. 先执行后面的指针（end），找出第一个比基准数小的数字
4. 再执行前面的指针（start），找出第一个比基准数大的数字
5. 交换两个指针指向的数字
6. 直到两个指针相遇
7. 将基准数跟指针指向位置的数字交换位置，称之为：基准数归位。
8. 第一轮结束之后，基准数左边的数字都是比基准数小的，基准数右边的数字都是比基准数大的。
9. 把基准数左边看做一个序列，把基准数右边看做一个序列，按照刚刚的规则递归排序

代码：
```java
    public static void quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;

        if (low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            //右边当发现小于p的值时停止循环
            while (arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while (arr[i] <= p && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort(arr, low, j - 1);  //对左边快排
        quickSort(arr, j + 1, high); //对右边快排
    }
```

### 归并排序（Merge Sort）
将一个未排序的数组分成两个子数组，然后递归地对子数组进行排序，最后将这两个有序的子数组合并以获得整个数组的有序结果。

代码：
```java
 public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
```

### 堆排序（Heap Sort）
利用二叉堆数据结构进行排序。堆排序分为两个主要步骤：建立堆和排序。建立堆阶段将无序的元素数组构建成一个堆（通常是最大堆或最小堆），而排序阶段则不断从堆中取出根节点元素，将其放在已排序部分的末尾，然后调整堆以恢复堆的性质。

```java
public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 从堆中提取元素一个个放入已排序部分
        for (int i = n - 1; i >= 0; i--) {
            // 交换堆顶元素（最大元素）和当前元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整堆以恢复堆的性质
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 在左子树中找到较大的元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 在右子树中找到较大的元素
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果根节点不是最大的，则交换根节点和最大元素
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归地调整子树
            heapify(arr, n, largest);
        }
    }
```

### 桶排序（Bucket Sort）

### 查找算法
基本查找（Linear Search）
二分查找（Binary Search）
插值查找（Interpolation Search）
斐波那契查找
哈希表查找（Hash Table Search）
树结构查找


### 递归
递归指方法中调用方法本身的现象
ps：递归一定要有出口，否则就会出现内存溢出
核心：
找规律；找出口

example：
```java
public class Recursive {
    public static void main(String[] args) {
        System.out.println(getSume(100));
    }

    public static int getSume(int mun) {
        if (mun == 1) {
            return 1;
        }
        return mun + getSume(mun - 1);
    }
}
```