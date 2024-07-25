package searchcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main5 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        String line;
        while ((line = in.readLine()) != null) {
            String[] words = line.split(" ");
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            System.out.println(longestWord);
        }
    }
}

