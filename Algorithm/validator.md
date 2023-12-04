# Validator 对数器
检查自己是不是写错了  
1. 你想要测的方法a（最优解）
2. 实现复杂度不好但是容易实现的方法b（暴力解）
3. 实现一个随机样本产生器（长度也随机、值也随机）
4. 把方法a和方法b跑相同的输入样本，看看得到的结果是否一样
5. 如果有一个随机样本使得比对结果不一致，打印这个出错的样本进行人工干预，改对方法a和方法b
6. 当样本数量很多时比对测试依然正确，可以确定方法a（最优解）已经正确。 


```java
    public static void main(String[] args) {
            // 随机数组最大长度
            int N = 200;
            // 随机数组每个值，在1~V之间等概率随机
            int V = 1000;
            // testTimes : 测试次数
            int testTimes = 50000;
            System.out.println("测试开始");
            for (int i = 0; i < testTimes; i++) {
                // 随机得到一个长度，长度在[0~N-1]
                int n = (int) (Math.random() * N);
                // 得到随机数组
                int[] arr = randomArray(n, V);
                //复制三份，独立空间
                int[] arr1 = copyArray(arr);
                int[] arr2 = copyArray(arr);
                int[] arr3 = copyArray(arr);
                selectionSort(arr1);
                bubbleSort(arr2);
                insertionSort(arr3);
                if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                    System.out.println("出错了!");
                    // 当有错了
                    // 打印是什么例子，出错的
                    // 打印三个功能，各自排序成了什么样
                    // 可能要把例子带入，每个方法，去debug！
                }
            }
            System.out.println("测试结束");
        }


    // 为了验证
	// 得到一个随机数组，长度是n
	// 数组中每个数，都在1~v之间，随机得到
	public static int[] randomArray(int n, int v) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			// Math.random() -> double -> [0,1)范围山的一个小数，0.37463473126、0.001231231，等概率！
			// Math.random() * v -> double -> [0,v)一个小数，依然等概率
			// (int)(Math.random() * v) -> int -> 0 1 2 3 ... v-1，等概率的！
			// (int) (Math.random() * v) + 1 -> int -> 1 2 3 .... v，等概率的！
			arr[i] = (int) (Math.random() * v) + 1;
		}
		return arr;
	}

    // 为了验证, 将原来数组copy一份
	public static int[] copyArray(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

    // 为了验证，看三个排序是不是得出的结果都一样
	public static boolean sameArray(int[] arr1, int[] arr2) {
		int n = arr1.length;
		for (int i = 0; i < n; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

```