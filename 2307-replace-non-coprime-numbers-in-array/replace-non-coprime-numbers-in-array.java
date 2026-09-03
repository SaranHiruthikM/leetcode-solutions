class Solution {

    public List<Integer> replaceNonCoprimes(int[] nums) {

        Stack<Long> st = new Stack<>();

        for (int num : nums) {

            long curr = num;

            // Keep merging with previous elements
            while (!st.isEmpty()) {

                long prev = st.peek();
                long gcd = gcd(prev, curr);

                // Coprime → cannot merge
                if (gcd == 1) {
                    break;
                }

                // Remove previous number
                st.pop();

                // LCM = (a / gcd) * b
                curr = (prev / gcd) * curr;
            }

            st.push(curr);
        }

        List<Integer> result = new ArrayList<>();

        while (!st.isEmpty()) {
            result.add(st.pop().intValue());
        }

        Collections.reverse(result);

        return result;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}