package dateclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        System.out.println(d.getTime());
        Date d2 = new Date(0L);
        System.out.println(d2);

        Date d1 = new Date(0L);
        long time = d1.getTime();

        time = time + 1000L * 60 * 60 * 24 * 365;
        d1.setTime(time);
        System.out.println(d1);

        // compare two time
        Random r = new Random();
        Date date1 = new Date(Math.abs(r.nextInt()));
        Date date2 = new Date(Math.abs(r.nextInt()));
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        if (time1 > time2) {
            System.out.println("time 1 large");
        } else if (time1 < time2) {
            System.out.println("time2 large");
        } else {
            System.out.println("two equals");
        }

        SimpleDateFormat s = new SimpleDateFormat("yyy-MM-dd HH:mm:ss EE");
        Date d3 = new Date(0L);
        String str = s.format(d3);
        System.out.println(str);

        String str1 = "2023-11-11 11:11:11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date da = sdf.parse(str1);
        System.out.println(da.getTime());
    }
}
