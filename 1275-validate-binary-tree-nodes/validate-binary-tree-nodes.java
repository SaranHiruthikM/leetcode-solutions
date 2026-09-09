class Solution {
    List<List<Integer>> adj = new ArrayList<>();

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int lc = leftChild[i];
            int rc = rightChild[i];

            if(lc != -1){
                adj.get(i).add(lc);
                if(map.containsKey(lc)){
                    return false;
                }
                map.put(lc, i);
            }

            if(rc != -1){
                adj.get(i).add(rc);
                if(map.containsKey(rc)){
                    return false;
                }
                map.put(rc, i);
            }
        }   

        int root = -1;
        for(int i=0; i<n; i++){
            if(!map.containsKey(i)){
                if(root != -1) return false;
                root = i;
            }
        }

        if(root == -1) return false; 

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            if(leftChild[curr] != -1){
                q.offer(leftChild[curr]);
            }

            if(rightChild[curr] != -1){
                q.offer(rightChild[curr]);
            }
        }

        if(count != n) return false;


        return true;
    }
}