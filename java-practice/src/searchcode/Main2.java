package searchcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] nums = line.split(" ");
            int num = Integer.parseInt(nums[0]);
            int result = num * num;
            System.out.println(result);
        }
    }
}

