class Solution {
    public int maximum69Number (int num) {
        String newNum = String.valueOf(num);
        if(newNum.length() == 1) return 9;
        int idx = -1;
        for(int i=0; i<newNum.length(); i++){
            if(Integer.parseInt(String.valueOf(newNum.charAt(i))) == 6){
                idx = i;
                break;
            }
        }

        if(idx == -1) return num;
        StringBuilder sb = new StringBuilder(newNum);
        sb.setCharAt(idx, '9');
        return Integer.parseInt(sb.toString());
    }
}