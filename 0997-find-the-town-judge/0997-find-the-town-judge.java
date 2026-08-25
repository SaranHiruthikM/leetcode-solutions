class Solution {
    public int findJudge(int n, int[][] trust) {
        int judge[] = new int[n+1];
        for(int trusts[] : trust){
            judge[trusts[1]]++;
            judge[trusts[0]]--;
        }

        for(int i=1; i<judge.length; i++){
            if(judge[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}