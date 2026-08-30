class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[n];
        PriorityQueue<long[]> meetRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> avlRooms = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            avlRooms.add(i);
        }
        for(int meet[]: meetings){
            int st = meet[0];
            int end = meet[1];
            int duration = end - st;
            while(!meetRooms.isEmpty() && meetRooms.peek()[0] <= st){
                long room[] = meetRooms.poll();
                avlRooms.add((int) room[1]); 
            }

            if(avlRooms.peek() != null){
                int room = avlRooms.poll();
                meetRooms.add(new long[]{end, room});
                result[room]++;
            }else{
                long top[] = meetRooms.poll();
                meetRooms.add(new long[]{top[0] + duration, top[1]});
                result[(int) top[1]]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int room = -1;
        for(int i=0; i<result.length; i++){
            if(result[i] > max){
                room = i;
                max = result[i];
            }
        }

        return room;
    }
}