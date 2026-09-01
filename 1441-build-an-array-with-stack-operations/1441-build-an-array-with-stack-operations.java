class Solution {
    public List<String> buildArray(int[] target, int n) {
        int num = 1;
        int len = target.length;
        int i= 0;
        List<String> res = new ArrayList<>();
        while(i < len && num <= n){
            if(target[i] == num){
                res.add("Push");
                i++;
            }else{
                res.add("Push");
                res.add("Pop");
            }
            num++;
        }

        return res;
    }
}