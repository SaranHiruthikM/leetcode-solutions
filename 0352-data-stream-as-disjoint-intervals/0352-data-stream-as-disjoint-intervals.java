import java.util.*;

class SummaryRanges {

    private TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        // Already inside an existing interval
        Integer left = map.floorKey(value);

        if (left != null && map.get(left) >= value) {
            return;
        }

        // First interval starting at or after value
        Integer right = map.ceilingKey(value);

        boolean connectLeft =
                left != null && map.get(left) + 1 == value;

        boolean connectRight =
                right != null && right - 1 == value;

        // Connect both intervals
        if (connectLeft && connectRight) {
            map.put(left, map.get(right));
            map.remove(right);
        }

        // Extend left interval
        else if (connectLeft) {
            map.put(left, value);
        }

        // Extend right interval
        else if (connectRight) {
            int end = map.get(right);

            map.remove(right);
            map.put(value, end);
        }

        // Create a new interval
        else {
            map.put(value, value);
        }
    }

    public int[][] getIntervals() {

        int[][] result = new int[map.size()][2];

        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        return result;
    }
}