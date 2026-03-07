class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for(int m : matchsticks)
            sum += m;

        if(sum % 4 != 0) return false;

        int side = sum / 4;

        Arrays.sort(matchsticks);

        int n = matchsticks.length;

        int[] sides = new int[4];

        return dfs(matchsticks, n - 1, sides, side);
    }

    public boolean dfs(int[] sticks, int index, int[] sides, int target){

        if(index < 0){
            return true;
        }

        int stick = sticks[index];

        for(int i = 0; i < 4; i++){

            if(sides[i] + stick > target)
                continue;

            sides[i] += stick;

            if(dfs(sticks, index - 1, sides, target))
                return true;

            sides[i] -= stick;

            if(sides[i] == 0)
                break;
        }

        return false;
    }
}