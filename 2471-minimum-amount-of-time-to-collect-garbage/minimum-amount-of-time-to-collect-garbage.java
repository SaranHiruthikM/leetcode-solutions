class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int g = 0;
        int p = 0;
        int m = 0;
        int lastG = 0;
        int lastP = 0;
        int lastM = 0;
        
        int prefix[] = new int[garbage.length];
        for(int i=1; i<garbage.length; i++){
            prefix[i] = travel[i-1] + prefix[i-1];
        }


        for(int i=0; i<garbage.length; i++){
            for(int j=0; j<garbage[i].length(); j++){
                char ch = garbage[i].charAt(j);
                if(ch == 'G'){
                    g++;
                    lastG = i;
                }else if(ch == 'P'){
                    p++;
                    lastP = i;
                }else{
                    m++;
                    lastM = i;
                }
            }
        }

        g += prefix[lastG];
        m += prefix[lastM];
        p += prefix[lastP];

        return g+p+m;
    }
}