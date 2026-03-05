class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        String res = "";
        while(true){
            res += numbers.get(k / fact);
            numbers.remove(k / fact);
            if(numbers.size() == 0){
                break;
            }
            k %= fact;
            fact /= numbers.size();
        }

        return res;
    }
}