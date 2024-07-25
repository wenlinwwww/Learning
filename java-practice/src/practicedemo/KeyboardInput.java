package practicedemo;

import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardInput {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner s  = new Scanner(System.in);
        while (true) {
            System.out.println("pls type a number between 1-100");
            String s1 = s.nextLine();
            if (Integer.parseInt(s1) <= 100 && Integer.parseInt(s1) >= 1) {
                arr.add(Integer.parseInt(s1));
                int sum = getSum(arr);
                if (sum > 200) break;
            } else {
                System.out.println("this is not a number within 0-100, pls try again");
            }
        }
        System.out.println("sum of list is over 200");
    }

    private static int getSum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

}
