package regularexpression3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://m.sengzan.com/jiaoyu/29104/.html?ivk_sa=10258831");
        URLConnection connection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        Pattern p = Pattern.compile("[1-9]\\d[17]]");
        while ((line = br.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
        br.close();
    }
}
