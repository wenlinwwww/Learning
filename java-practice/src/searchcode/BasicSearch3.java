package searchcode;

import java.util.ArrayList;

public class BasicSearch3 {
    public static void main(String[] args) {
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79, 81};
        System.out.println(searchAllIndex(arr, 81));

    }

    public static String searchAllIndex(int[] arr, int num) {
        ArrayList<Integer> a = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                a.add(i);
            }
        }
        if (a.isEmpty()) {
            return "not in the list";
        } else {
            for (Integer i : a) {
                assert false;
                s.append(i);
                s.append(" ");
            }
            return s.toString();
        }
    }
}
