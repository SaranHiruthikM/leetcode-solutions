class Solution {
    public int sortPermutation(int[] nums) {
        // Initialize ans with all bits set (-1 represents 1111...1111 in two's complement)
        int ans = -1;
        boolean isSorted = true;

        for (int i = 0; i < nums.length; ++i) {
            // Check if the current element is misplaced
            if (i != nums[i]) {
                ans &= nums[i];
                isSorted = false;
            }
        }

        // If the array is already sorted, return 0. Otherwise, return the accumulated AND value.
        return isSorted ? 0 : ans;
    }
}
