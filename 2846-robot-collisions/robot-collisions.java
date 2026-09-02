class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] robots = new Integer[n];
        for (int i = 0; i < n; i++) {
            robots[i] = i;
        }

        Arrays.sort(robots, (a, b) ->
            Integer.compare(positions[a], positions[b])
        );

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            int curr = robots[i];
            if(directions.charAt(curr) == 'R'){
                st.push(curr);
            }else{
                while(!st.isEmpty()){
                    int prev = st.peek();

                    if(healths[prev] > healths[curr]){
                        healths[curr] = 0;
                        healths[prev]--;
                        break;
                    }else if(healths[prev] < healths[curr]){
                        st.pop();
                        healths[curr]--;
                        healths[prev] = 0;
                    }else{
                        st.pop();
                        healths[curr] = 0;
                        healths[prev] = 0;
                        break;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int health : healths){
            if(health > 0){
                res.add(health);
            }
        }

        return res;
    }
}