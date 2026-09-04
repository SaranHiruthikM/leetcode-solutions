class Solution {
    int[] parent;
    int[] rank;

    private int find(int i){
        if(i == parent[i]){
            return parent[i];
        }

        return parent[i] = find(parent[i]);
    }

    private void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[x_parent] = y_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for(int i=0; i<26; i++){
            parent[i] = i;
        }

        for(String eq : equations){
            if(eq.charAt(1) == '='){
                union(eq.charAt(0) - 'a',eq.charAt(3) - 'a');
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int x_parent = find(eq.charAt(0)-'a');
                int y_parent = find(eq.charAt(3)-'a');

                if(x_parent == y_parent){
                    return false;
                }
            }
        }

        return true;
    }
}