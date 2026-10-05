class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                // R acts first and bans D
                r.offer(ri + n);
            } else {
                // D acts first and bans R
                d.offer(di + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}