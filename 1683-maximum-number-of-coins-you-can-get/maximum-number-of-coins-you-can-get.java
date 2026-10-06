class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int limit = piles.length/3;
        int ans = 0;
        for(int i=piles.length-2; i>=limit; i-=2){
            ans += piles[i];
        }

        return ans;
    }
}