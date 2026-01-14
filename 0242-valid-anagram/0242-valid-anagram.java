class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for(int i=0; i<s.length(); i++){
            int index1 = s.charAt(i) - 'a';
            int index2 = t.charAt(i) - 'a';
            arr1[index1]++;
            arr2[index2]++;
        }
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}