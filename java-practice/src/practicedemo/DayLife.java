package practicedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DayLife {
    public static void main(String[] args) throws ParseException {
        String birth = "2000-01-19";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(birth);
        long m1 = d.getTime();
        long current = System.currentTimeMillis();
        long l = current - m1;
        System.out.println(l / 1000 / 60 / 60/ 24);

        // period method
        LocalDate localDateTime = LocalDate.of(2000, 1,19);
        LocalDate now = LocalDate.now();
        long between = ChronoUnit.DAYS.between(localDateTime, now);
        System.out.println(between);

    }
}
