class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            int curr = asteroids[i];
            if(curr < 0){
                boolean currSurvived = true;
                while(!st.isEmpty() && st.peek() > 0){
                    int abs = Math.abs(curr);
                    if(st.peek() < abs){
                        st.pop();
                    }else if(st.peek() == abs){
                        st.pop();
                        currSurvived = false;
                        break;
                    }else{
                        currSurvived = false;
                        break;
                    }
                }

                if(currSurvived) st.push(curr);
            }else{
                st.push(curr);
            }
        }

        while(!st.isEmpty()){
            res.add(st.pop());
        }


        Collections.reverse(res);
        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}