package searchcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] words = line.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    char firstChar = Character.toUpperCase(word.charAt(0));
                    result.append(firstChar).append(word.substring(1)).append(" ");
                }
            }
            result.deleteCharAt(result.length() - 1);
            System.out.println(result);
        }
    }
}

