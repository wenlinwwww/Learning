package searchcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;

public class Practice {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            int[] cards = new int[5];
            String[] allCard = line.trim().split(" ");
            for (int i = 0; i < allCard.length; i++) {
                cards[i] = Integer.parseInt(allCard[i]);
            }
            if (isReach(cards, 0)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }
    }

    private static void swap(int[] cards, int index, int newIndex) {
        int temp = cards[index];
        cards[index] = cards[newIndex];
        cards[newIndex] = temp;
    }

    private static boolean isReach(int[] cards, int start) {
        if (start == cards.length - 1) {
            return operation(cards, 0, cards[0]);
        }
        for (int i = start; i < cards.length; i++) {
            swap(cards, start, i);
            if (isReach(cards, start+1)) {
                return true;
            }
            swap(cards, start, i);
        }
        return false;
    }

    private static boolean operation(int[] cards, int start, int value) {
        if (start == cards.length - 1) {
            return value == 42;
        }
        return operation(cards, start+1, value + cards[start+1])
                || operation(cards, start+1, value - cards[start+1])
                || operation(cards, start+1, value * cards[start+1]);
    }
}
