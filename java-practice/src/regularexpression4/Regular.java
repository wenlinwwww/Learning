package regularexpression4;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        String str = "nowadays there exist java 21, but in before uni always teach student java 8 or java 11.";
        String a = "abbbbbbbbccccccc";
        String rgx = "ab+";
        String rgx2 = "ab+?";
        Pattern p = Pattern.compile(rgx);
        Pattern p2 = Pattern.compile(rgx2);
        Matcher m = p.matcher(a);
        Matcher m2 = p2.matcher(a);
        m.find();
        m2.find();
        System.out.println(m.group());
        System.out.println(m2.group());


    }


}

