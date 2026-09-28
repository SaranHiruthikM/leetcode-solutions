class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indeg[] = new int[n];
        for(int i=0; i<edges.size(); i++){
            indeg[edges.get(i).get(1)]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0) res.add(i);
        }

        return res;
    }
}