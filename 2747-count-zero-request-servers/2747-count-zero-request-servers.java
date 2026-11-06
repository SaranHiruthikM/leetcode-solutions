
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] freq = new int[n + 1];
        int[] ans = new int[queries.length];

        int left = 0, right = 0;
        int active = 0;

        for (int[] query : q) {

            int start = query[0] - x;
            int end = query[0];

            while (right < logs.length && logs[right][1] <= end) {
                int id = logs[right][0];

                if (freq[id] == 0)
                    active++;

                freq[id]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int id = logs[left][0];

                freq[id]--;

                if (freq[id] == 0)
                    active--;

                left++;
            }

            ans[query[1]] = n - active;
        }

        return ans;
    }
}
