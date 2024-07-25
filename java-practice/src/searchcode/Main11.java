package searchcode;

import java.util.*;

public class Main11 {

    public static void main(String[] args) {
        int time_to_live = 5;
        String[][] queries = {
                {"generate", "aaa", "1"},
                {"renew", "aaa", "2"},
                {"count", "6"},
                {"generate", "bbb", "7"},
                {"renew", "aaa", "8"},
                {"renew", "bbb", "10"},
                {"count", "15"}
        };

        int[] result = getUnexpiredTokens2(time_to_live, queries);
        for (int count : result) {
            System.out.println(count);
        }
    }

    public static int[] getUnexpiredTokens(int time_to_live, String[][] queries) {
        HashMap<String, Integer> tokenExpiryTimes = new HashMap<>();
        List<Integer> counts = new ArrayList<>();

        for (String[] query : queries) {
            String type = query[0];
            String token_id = query.length > 1 ? query[1] : null;
            int current_time = Integer.parseInt(query[query.length - 1]);

            tokenExpiryTimes.entrySet().removeIf(entry -> entry.getValue() <= current_time);

            switch (type) {
                case "generate":
                    tokenExpiryTimes.put(token_id, current_time + time_to_live);
                    break;
                case "renew":
                    if (tokenExpiryTimes.containsKey(token_id) && tokenExpiryTimes.get(token_id) > current_time) {
                        tokenExpiryTimes.put(token_id, current_time + time_to_live);
                    }
                    break;
                case "count":
                    counts.add(tokenExpiryTimes.size());
                    break;
            }
        }
        return counts.stream().mapToInt(i -> i).toArray();
    }

    public static int[] getUnexpiredTokens2(int time_to_live, String[][] queries) {
        String[] tokens = new String[1000];
        int[] expiryTimes = new int[1000];
        int tokenCount = 0;

        int[] tempCounts = new int[queries.length];
        int countIndex = 0;
        for (String[] query : queries) {
            String type = query[0];
            String token_id = query.length > 1 ? query[1] : null;
            int current_time = Integer.parseInt(query[query.length - 1]);
            for (int i = 0; i < tokenCount; i++) {
                if (expiryTimes[i] <= current_time) {
                    tokens[i] = tokens[tokenCount - 1];
                    expiryTimes[i] = expiryTimes[tokenCount - 1];
                    tokenCount--;
                    i--;
                }
            }
            switch (type) {
                case "generate":
                    tokens[tokenCount] = token_id;
                    expiryTimes[tokenCount] = current_time + time_to_live;
                    tokenCount++;
                    break;
                case "renew":
                    for (int i = 0; i < tokenCount; i++) {
                        if (tokens[i].equals(token_id) && expiryTimes[i] > current_time) {
                            expiryTimes[i] = current_time + time_to_live;
                            break;
                        }
                    }
                    break;
                case "count":
                    tempCounts[countIndex++] = tokenCount;
                    break;
            }
        }

        int[] counts = new int[countIndex];
        System.arraycopy(tempCounts, 0, counts, 0, countIndex);
        return counts;
    }

}
