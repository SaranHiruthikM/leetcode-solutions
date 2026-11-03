class Solution {
    public int findChampion(int n, int[][] edges) {
        int indeg[] = new int[n];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            indeg[v]++;
        }
        
        int count = 0;
        int comp = -1;
        for(int i=0; i<n; i++){
            if(indeg[i] == 0){
                count++;
                comp = i;
            }
        }
        
        return (count == 0 || count > 1) ? -1 :  comp;
    }
}