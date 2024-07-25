package sort_demo;

import java.util.Arrays;
import java.util.Comparator;

public class DescendingSort {
    public static void main(String[] args) {
        Integer[] arr = {2,3,1,5,6,7,8,4,9};

        //sort原理：利用插入排序+二分查找，进行排序
        //默认把0索引的数据当作是有序的序列，1索引到最后是无序的序列、
        //遍历无序的得到里面每一个元素，假设当前遍历的数组是a元素
        //把a往有序数组中插入，插入的时候，是利用二分查找确定a的插入点
        //拿着a元素，跟插入点的元素进行比较，比较的规则就是compare方法
        //如果方法返回的是负数，拿着a元素继续跟前面的数据对比，
        // 如果返回的是正数，那就会拿着a和后面的比较
        //如果返回是0，那就拿着a和后面比较
        //直到能确认最后位置

        //简单记忆：
        //o1 - o2:升序排列
        //o2 - o1:降序排列

        //参数o1:表示在无序序列中，遍历得到的每一个元素
        //参数o2:有序序列中的元素

        //返回值：
        //负数：-1，-2
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
