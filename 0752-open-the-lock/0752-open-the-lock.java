class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer("0000");
        vis.add("0000");

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            while (size-- > 0) {
                String curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int d = curr.charAt(i) - '0';

                    int[] nextDigits = {
                        (d + 1) % 10,
                        (d + 9) % 10
                    };

                    for (int nextDigit : nextDigits) {
                        StringBuilder next = new StringBuilder(curr);
                        next.setCharAt(i, (char) ('0' + nextDigit));

                        String state = next.toString();

                        if (state.equals(target)) return level;

                        if (!dead.contains(state) && vis.add(state)) {
                            q.offer(state);
                        }
                    }
                }
            }
        }

        return -1;
    }
}