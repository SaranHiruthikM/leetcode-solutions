class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        int level = 0;
        char charArr[] = {'A', 'G', 'C', 'T'};
        Set<String> visited = new HashSet<>();
        Set<String> newBank = new HashSet<>(Arrays.asList(bank));
        visited.add(startGene);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String word = q.poll();
                if(word.equals(endGene)){
                    return level;
                }
                char curr[] = word.toCharArray();
                for(int pos=0; pos<curr.length; pos++){
                    char original = curr[pos];
                    for(char ch : charArr){
                        if(ch == original){
                            continue;
                        }

                        curr[pos] = ch;

                        String updated = new String(curr);

                        if(!visited.contains(updated) && newBank.contains(updated)){
                            q.offer(updated);
                            visited.add(updated);
                        }
                    }
                    curr[pos] = original;
                }
            }

            level++;
        }

        return -1;
    }
}