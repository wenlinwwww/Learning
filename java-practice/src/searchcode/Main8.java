package searchcode;

import java.util.*;

public class Main8 {

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        long maxUnits = 0;
        int n = boxes.size();

        // Create a list of products with total units per box
        List<Long> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            products.add(boxes.get(i) * unitsPerBox.get(i));
        }

        products.sort(Collections.reverseOrder());
        for (int i = 0; i < n && truckSize > 0; i++) {
            long boxesToLoad = Math.min(boxes.get(i), truckSize);
            maxUnits += boxesToLoad * unitsPerBox.get(i);
            truckSize -= boxesToLoad;
        }

        return maxUnits;
    }

    public static void main(String[] args) {
        List<Long> boxes = Arrays.asList(3L, 1L, 6L);
        List<Long> unitsPerBox = Arrays.asList(2L, 7L, 4L);
        long truckSize = 6L;

        System.out.println(getMaxUnits(boxes, unitsPerBox, truckSize));
    }
}
