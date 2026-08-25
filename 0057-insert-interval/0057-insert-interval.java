class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int newStart = newInterval[0];
            int newEnd = newInterval[1];

            if(currEnd < newStart){
                res.add(intervals[i]);
            } else if (currStart > newEnd){
                res.add(new int[]{newStart, newEnd});

                for(int j=i; j<intervals.length; j++){
                    res.add(intervals[j]);
                }

                return res.toArray(new int[res.size()][]);
            }else {
                newInterval[0] = Math.min(currStart, newStart);
                newInterval[1] = Math.max(currEnd, newEnd);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);        
    }
}