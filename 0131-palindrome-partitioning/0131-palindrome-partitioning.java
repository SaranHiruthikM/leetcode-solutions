class Solution {
    List<List<String>> res = new ArrayList<>();

    public boolean isPalin(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void helper(String s, List<String> arr){

        if(s.length() == 0){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=0; i<s.length(); i++){
            String part = s.substring(0, i+1);
            if(isPalin(part)){
                arr.add(part);
                helper(s.substring(i+1), arr);
                arr.remove(arr.size() -1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<String> arr = new ArrayList<>();
        helper(s, arr);
        return res;
    }
}