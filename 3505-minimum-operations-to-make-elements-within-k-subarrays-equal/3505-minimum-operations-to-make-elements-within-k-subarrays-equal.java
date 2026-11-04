
import java.util.*;

class Solution {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    Map<Integer, Integer> delayed = new HashMap<>();

    long leftSum = 0, rightSum = 0;
    int leftSize = 0, rightSize = 0;

    void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int val = pq.peek();

            if (delayed.getOrDefault(val, 0) == 0)
                break;

            pq.poll();

            delayed.put(val, delayed.get(val) - 1);
        }
    }

    void balance() {
        prune(left);
        prune(right);

        while (leftSize > rightSize + 1) {
            int val = left.poll();

            leftSum -= val;
            leftSize--;

            right.offer(val);
            rightSum += val;
            rightSize++;

            prune(left);
        }

        while (leftSize < rightSize) {
            int val = right.poll();

            rightSum -= val;
            rightSize--;

            left.offer(val);
            leftSum += val;
            leftSize++;

            prune(right);
        }
    }

    void add(int val) {
        prune(left);

        if (left.isEmpty() || val <= left.peek()) {
            left.offer(val);
            leftSum += val;
            leftSize++;
        } else {
            right.offer(val);
            rightSum += val;
            rightSize++;
        }

        balance();
    }

    void remove(int val) {
        prune(left);

        delayed.put(val, delayed.getOrDefault(val, 0) + 1);

        if (val <= left.peek()) {
            leftSum -= val;
            leftSize--;

            if (val == left.peek())
                prune(left);
        } else {
            rightSum -= val;
            rightSize--;

            if (!right.isEmpty() && val == right.peek())
                prune(right);
        }

        balance();
    }

    long getCost() {
        prune(left);

        long median = left.peek();

        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            add(nums[i]);

            if (i >= x)
                remove(nums[i - x]);

            if (i >= x - 1)
                cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
