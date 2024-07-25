package regularexpression2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        String str = "nowadays there exist java 21, but in before uni always teach student java 8 or java 11.";
        System.out.println(findWord("java \\d{0,2}", str));
    }
    public static String findWord(String str, String str2) {
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(str2);
        StringBuilder s = new StringBuilder();
        while (m.find()) {
            s.append(m.group());
            s.append(" ");
        }
        return s.toString();
    }
}
