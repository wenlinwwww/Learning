package searchcode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // Iterate through each line of input.
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;

        while ((line = in.readLine()) != null) {
            String[] parts = line.split("\\|");
            String[] list1 = parts[0].trim().split("\\s+");
            String[] list2 = parts[1].trim().split("\\s+");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < list1.length; i++) {
                int num1 = Integer.parseInt(list1[i]);
                int num2 = Integer.parseInt(list2[i]);
                int product = num1 * num2;
                result.append(product).append(" ");
            }

            System.out.println(result.toString().trim());
        }
    }
}
