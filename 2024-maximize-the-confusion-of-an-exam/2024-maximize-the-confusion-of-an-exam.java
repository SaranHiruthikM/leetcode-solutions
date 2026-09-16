class Solution {
    private int slidingWindow(String answerKey, int k, char letterToFlip){
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right < answerKey.length()){
            char ch = answerKey.charAt(right);
            if(ch == letterToFlip && k <= 0){
                k++;
                while(answerKey.charAt(left) != letterToFlip){
                    left++;
                }
                left++;
            }

            if(ch == letterToFlip) k--;
            max = Math.max(max, right - left+1);
            right++;
        }

        return max;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(slidingWindow(answerKey, k, 'F'), slidingWindow(answerKey, k, 'T'));
    }
}