class Solution {
    public int reverseDegree(String s) {
        int reversedDegree = 0;
        for(int i=0; i<s.length(); i++){
            reversedDegree += ('z' + 1 - s.charAt(i)) * (i+1);
        }

        return reversedDegree;
    }
}