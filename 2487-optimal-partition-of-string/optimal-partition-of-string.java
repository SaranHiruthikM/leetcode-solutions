class Solution {
    public int partitionString(String s) {
        int lastSeen[] = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(lastSeen[ch - 'a'] >= start){
                start = i;
                count++;
            }
            lastSeen[ch - 'a'] = i;
        }

        return count+1;
    }
}