class Solution {
    public int maximum69Number (int num) {
        String newNum = String.valueOf(num);
        int idx = -1;
        for(int i=0; i<newNum.length(); i++){
            if(newNum.charAt(i) == '6'){
                idx = i;
                break;
            }
        }

        if(idx == -1) return num;
        int len = (int) Math.pow(10, newNum.length() - idx - 1);
        return num + 3*len;
    }
}