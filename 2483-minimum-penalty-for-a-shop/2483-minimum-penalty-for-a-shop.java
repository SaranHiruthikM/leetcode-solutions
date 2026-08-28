class Solution {
    public int bestClosingTime(String customers) {
        
        int minPenIdx = 0;
        int open = 0;
        int closed = 0;
        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                closed++;
            }
        }

        if(closed == 0){
            return 0;
        }

        int minPen = closed;

        for(int i=0; i<customers.length(); i++){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                closed--;
            }else{
                open++;
            }

            if((open + closed) < minPen){
                minPen = open+closed;
                minPenIdx = i+1;
            }
        }

        return minPenIdx;
    }
}