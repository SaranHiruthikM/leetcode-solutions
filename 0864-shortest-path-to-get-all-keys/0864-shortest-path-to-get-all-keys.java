class Solution {
    int dirs[][] = {
        {0, -1},
        {0, 1},
        {1, 0},
        {-1, 0}
    };
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int keys = 0;
        int n = grid[0].length();
        int strow = 0;
        int stcol = 0;
    
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i].charAt(j) == '@'){
                    strow=i;
                    stcol=j;
                }
                if(Character.isLowerCase(grid[i].charAt(j))){
                    keys++;
                }
            }
        }

        int targetMask = (1 << keys) -1;

        Queue<int[]> q = new LinkedList<>();
        int level = 0;
        boolean[][][] vis = new boolean[m][n][1 << keys];
        q.add(new int[]{strow, stcol, 0});
        vis[strow][stcol][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];
                int mask = curr[2];

                if(mask == targetMask){
                    return level;
                }

                for(int dir[] : dirs){
                    int cr = row + dir[0];
                    int cc = col + dir[1];

                    if (cr < 0 || cr >= m || cc < 0 || cc >= n) {
                        continue;
                    }

                    char ch = grid[cr].charAt(cc);

                    if(ch == '#'){
                        continue;
                    }

                    int newMask = mask;

                    if(ch >= 'a' && ch <= 'f'){
                        newMask |= (1 << ch-'a');
                    }

                    if(ch >= 'A' &&  ch <= 'F'){
                        if((mask & (1 << ch-'A')) == 0){
                            continue;
                        }
                    }

                    if(!vis[cr][cc][newMask]){
                        vis[cr][cc][newMask] = true;
                        q.add(new int[]{cr, cc, newMask});
                    }
                }
            }
            level++;
        }

        return -1;
    }
}