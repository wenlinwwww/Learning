package searchcode;

public class Main12 {
    public static void main(String[] args) {
        String s = "1000110";
        int k = 3;
        System.out.println("Maximum consecutive dance moves: " + maximizeConsecutiveDanceMoves(s, k));

    }

    public static int maximizeConsecutiveDanceMoves(String s, int k) {
        int left = 0, right = 0;
        int maxConsecutiveOnes = 0;
        int zeroCount = 0;
        for (right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (s.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }
        return maxConsecutiveOnes - 1;
    }
}

