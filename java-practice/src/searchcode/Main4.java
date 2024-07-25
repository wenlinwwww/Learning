import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        String line;
        while ((line = in.readLine()) != null) {
            String[] tokens = line.split(" ");
            int[] cards = new int[5];
            for (int i = 0; i < 5; i++) {
                cards[i] = Integer.parseInt(tokens[i]);
            }

            if (isPossibleToReach42(cards, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPossibleToReach42(int[] cards, int start) {
        if (start == cards.length - 1) {
            return isPossibleToReach(cards, 0, cards[0]);
        }
        for (int i = start; i < cards.length; i++) {
            swap(cards, start, i);
            if (isPossibleToReach42(cards, start + 1)) {
                return true;
            }
            swap(cards, start, i);
        }
        return false;
    }

    private static void swap(int[] cards, int i, int j) {
        int temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    private static boolean isPossibleToReach(int[] cards, int index, int value) {
        if (index == cards.length - 1) {
            return value == 42;
        }

        return isPossibleToReach(cards, index + 1, value + cards[index + 1])
                || isPossibleToReach(cards, index + 1, value - cards[index + 1])
                || isPossibleToReach(cards, index + 1, value * cards[index + 1]);
    }
}
