class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        boolean centreUsed = false;
        int cnt = 0;
        for(String word : words){
            String rev = new StringBuilder(word).reverse().toString();
            if(!word.equals(rev)){
                if(map.getOrDefault(word, 0) >0 && map.getOrDefault(rev, 0) > 0){
                    cnt += 4;
                    map.put(word, map.getOrDefault(word, 0) - 1);
                    map.put(rev, map.getOrDefault(rev, 0) - 1);
                }
            }else{
                if(map.getOrDefault(word, 0) >= 2){
                    cnt += 4;
                    map.put(word, map.getOrDefault(word, 0) - 2);
                }else if(map.getOrDefault(word, 0) > 0 && !centreUsed){
                    cnt += 2;
                    centreUsed = true;
                }
            }

        }
            return cnt;
    }
}