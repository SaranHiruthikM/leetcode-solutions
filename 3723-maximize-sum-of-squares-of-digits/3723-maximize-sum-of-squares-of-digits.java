class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num || sum < 1){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while(num-- > 0){
            if(sum - 9 >= 0){
                ans.append((char) ('0' + 9));
                sum -= 9;
            }else if(sum > 0){
                ans.append((char) ('0' + sum));
                sum -= sum;
            }else{
                ans.append((char) ('0' + 0));
            }
        }
        return ans.toString();
    }
}