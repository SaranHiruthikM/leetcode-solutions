class Solution {
    HashMap<Character, List<Character>> adj = new HashMap<>();
    private char dfs(char curr, boolean vis[]){
        vis[curr - 'a'] = true;
        char minChar = curr;
        for(char neighbours : adj.getOrDefault(curr, new ArrayList<>())){
            if(!vis[neighbours - 'a']){
                char dfs_val = dfs(neighbours, vis);
                minChar = (minChar < dfs_val) ? minChar : dfs_val;
                
            }
        }

        return minChar;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0; i<s1.length(); i++){
            adj.computeIfAbsent(s1.charAt(i), k -> new ArrayList<>()).add(s2.charAt(i));
            adj.computeIfAbsent(s2.charAt(i), k -> new ArrayList<>()).add(s1.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<baseStr.length(); i++){
           sb.append(dfs(baseStr.charAt(i), new boolean[26]));
        }

        return sb.toString();
    }
}