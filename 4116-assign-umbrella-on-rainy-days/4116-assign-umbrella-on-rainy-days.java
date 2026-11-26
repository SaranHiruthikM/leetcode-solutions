class Solution {
    public String[] assignUmbrella(int[] rain) {
        int aliceCount = 0;
        int bobCount = 0;
        int n = rain.length;
        String res[] = new String[n];
        for(int i=0; i<n-1; i++){
            if(rain[i] == 0){
                res[i] = "None";
            }else{
                if(rain[i+1] == 1){
                    if(aliceCount == bobCount || aliceCount < bobCount){
                        res[i] = "Alice";
                        aliceCount++;
                    }else{
                        res[i] = "Bob";
                        bobCount++;
                    }
                }else{
                    res[i] = "Bob";
                    bobCount++;
                }
            }
        }

        if(rain[n-1] == 1) res[n-1] = "Bob";
        else res[n-1] = "None";

        return res;
    }
}