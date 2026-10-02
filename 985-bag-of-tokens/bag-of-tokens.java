class Solution {
    public int bagOfTokensScore(int[] token, int power) {
        Arrays.sort(token);
        int max = Integer.MIN_VALUE;
        int score = 0;
        int maxScore = 0;
        int i =0;
        int j = token.length-1;
        while(i <= j){
            if(power - token[i] >= 0){
                power -= token[i];
                score++;
                i++;
                maxScore = Math.max(maxScore, score);
            }else if(score >= 1){
                power += token[j];
                score--;
                j--;
            }else {
                return maxScore;
            }
        }

        return maxScore;
    }
}