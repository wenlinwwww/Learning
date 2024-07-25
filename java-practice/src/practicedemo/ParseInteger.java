package practicedemo;

import java.util.regex.Matcher;

public class ParseInteger {
    public static void main(String[] args) {
        String str = "1234567";

        if (!str.matches("[1-9]\\d{0,9}")) {
            System.out.println("data format error");
        } else {
            System.out.println("format correct");
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - '0';
                num = num * 10 +  c;
            }
            System.out.println("number is " + num);
        }
    }
}
