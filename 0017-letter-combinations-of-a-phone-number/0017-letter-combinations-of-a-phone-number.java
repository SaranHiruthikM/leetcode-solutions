class Solution {
    List<String> res = new ArrayList<>();

    public void helper(String str, String num, int index, HashMap<Character, String> map){
        if(index == num.length()){
            res.add(str);
            return;
        }

        String digitStr = map.get(num.charAt(index));
        for(int i=0; i<digitStr.length(); i++){
            helper(str + digitStr.charAt(i), num, index+1, map);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper("", digits, 0, map);
        return res;
    }
}