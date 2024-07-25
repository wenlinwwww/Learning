package lambdademo;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        Integer[] arr = {2,3,1,5,6,7,8,4,9};
/*        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        //用lambda写的，和上面是一样的
        Arrays.sort(arr, (Integer o1, Integer o2) -> o2 - o1
        );
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
}
