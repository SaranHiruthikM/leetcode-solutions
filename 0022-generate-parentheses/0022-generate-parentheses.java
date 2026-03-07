class Solution {
    List<String> ans = new ArrayList<>();
    public void helper(String paren, int open, int close, int n){
        if(paren.length() == 2*n){
            ans.add(paren);
            return;
        }

        if(open < n){
            helper(paren + "(", open+1, close, n);
        }
        if(close < open){
            helper(paren + ")", open, close+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, n);
        return ans;
    }
}