class Solution {
    public String maxPoints(String input, String maxStr){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<input.length(); i++){
            sb.append(input.charAt(i));
            int n = sb.length();
            if(n >= 2 && sb.charAt(n-1) == maxStr.charAt(1) && sb.charAt(n-2) == maxStr.charAt(0)){
                sb.setLength(sb.length() - 2);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
    public int maximumGain(String s, int x, int y) {
        
        int totPoints = 0;
        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (maxStr.equals("ab")) ? "ba" : "ab";
        

        String firstStr = maxPoints(s, maxStr);
        totPoints += (s.length() - firstStr.length())*Math.max(x, y)/2;
        String secondStr = maxPoints(firstStr, minStr);
        totPoints += (firstStr.length() - secondStr.length())*Math.min(x, y)/2;
        return totPoints;
    }
}