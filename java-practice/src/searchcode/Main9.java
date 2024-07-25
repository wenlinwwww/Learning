package searchcode;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class Main9 {

    public static void main(String[] args) {
        List<Long> boxes = Arrays.asList(3L, 1L, 6L);
        List<Long> unitsPerBox = Arrays.asList(2L, 7L, 4L);
        long truckSize = 6;

        System.out.println(getMaxUnits(boxes, unitsPerBox, truckSize));
    }
    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // Create a priority queue to sort the box types by units per box in descending order
        PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));

        // Add each box type to the heap
        for (int i = 0; i < boxes.size(); i++) {
            heap.offer(new long[]{boxes.get(i), unitsPerBox.get(i)});
        }

        long totalMaxUnits = 0;
        while (!heap.isEmpty() && truckSize > 0) {
            long[] boxAndUnitCount = heap.poll();
            long boxesToLoad = Math.min(truckSize, boxAndUnitCount[0]);

            totalMaxUnits += boxesToLoad * boxAndUnitCount[1];
            truckSize -= boxesToLoad;
        }

        return totalMaxUnits;
    }
}
