package dateclass2;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class CalenderDemo {
    public static void main(String[] args) {
        //根据电脑不同时区，获取不同内容，把时间等等放在一个数组里面
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        // in the list, index 0 is era, index 1 is year, index 2 is month, index 3 is number of weeks in the year
        int i = c.get(Calendar.YEAR);
        int i1 = c.get(Calendar.MONTH)+1;
        int i2= c.get(Calendar.DAY_OF_WEEK);
        System.out.println(i+ "month" + i1 + "data" + getWeek(i2));
        c.set(Calendar.YEAR, 2000);
        //add a month
        c.add(Calendar.MONTH, 1);

        Instant instant1 = Instant.ofEpochMilli(0L);
        Instant instant2 = Instant.ofEpochMilli(100000L);
        System.out.println(instant1);
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Australia/Melbourne"));
        System.out.println(zonedDateTime);
        boolean after1 = instant1.isAfter(instant2);
        boolean before1 = instant1.isBefore(instant2);
        Instant instant = instant1.minusMillis(1);

    }

    public static String getWeek(int i) {
        String[] arr = {"","Sunday","Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return arr[i];
    }
}
