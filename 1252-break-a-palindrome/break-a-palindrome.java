class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        for(int i=0; i<palindrome.length()/2; i++){
            char ch = palindrome.charAt(i);
            
            if(ch != 'a'){
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i+1, palindrome.length());
            }

        }

        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}