class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, right = 0, res = 0, zeroCnt = 0, oneCnt = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(ch == '0'){
                zeroCnt++;
            }else{
                oneCnt++;
            }

            while(zeroCnt > k && oneCnt > k){
                if(s.charAt(left) == '0'){
                    zeroCnt--;
                }else{
                    oneCnt--;
                }
                left++;
            }
            res += (right - left + 1);
            right++;
        }
        return res;
    }
}