class Solution {
    public boolean winnerOfGame(String colors) {
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();
        for(int i=1; i<colors.length()-1; i++){
            if(colors.charAt(i) == 'A' && colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A'){
                a.offer(i);
            }else if(colors.charAt(i) == 'B' && colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B'){
                b.offer(i);
            }
        }

        char turn = 'A';
        while(!a.isEmpty() && !b.isEmpty()){
            if(turn == 'A'){
                a.poll();
            }else{
                b.poll();
            }
            turn = (turn == 'A') ? 'B' : 'A';
        }

        return !a.isEmpty();
    }
}