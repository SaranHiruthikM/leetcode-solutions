class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }

        for(int size: map.keySet())
            if(map.get(size).size() > 0){
                int sz = map.get(size).size();
                int j = 0;
                while(j < sz){
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(map.get(size).subList(j, j+size));
                    res.add(temp);
                    j += size;
                }
    
        }
        return res;
    }
}