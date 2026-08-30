class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr >= low && curr <= high){
                list.add(curr);
            }
            int rem = curr % 10;
            if(rem == 9){
                continue;
            }
            int newNum = curr*10 + (rem+1);
            
            if(newNum <= high){
                q.add(newNum);
            }
        }

        return list;
    }
}