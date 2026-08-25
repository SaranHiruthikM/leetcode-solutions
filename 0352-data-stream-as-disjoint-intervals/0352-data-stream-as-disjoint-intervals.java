class SummaryRanges {
    HashSet<Integer> set;
    public SummaryRanges() {
        this.set = new HashSet<>();
    }
    
    public void addNum(int value) {
        this.set.add(value);
    }
    
    public int[][] getIntervals() {
        List<Integer> list = new ArrayList<>(set);
        List<int[]> res = new ArrayList<>();
        list.sort(Comparator.naturalOrder());
        int n = list.size();
        for(int i=0; i<n; i++){
            int left = list.get(i);
            while(i < n-1 && list.get(i)+1 == list.get(i+1)){
                i++;
            }
            res.add(new int[]{left, list.get(i)});

        }

        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */