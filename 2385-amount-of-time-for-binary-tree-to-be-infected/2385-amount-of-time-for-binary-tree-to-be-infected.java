/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode targetNode = null;
    public void inorder(TreeNode root, int target){
        if (root == null){
            return;
        }

        if(root.val == target){
            targetNode = root;
        }

        if(root.left != null){
            parent.put(root.left, root);
        }
        inorder(root.left, target);
        if(root.right != null){
            parent.put(root.right, root);
        }
        inorder(root.right, target);
    }
    public int BFS(TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> vis = new HashMap<>();
        q.offer(target);
        vis.put(target, 1);
        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !vis.containsKey(curr.left)){
                    q.offer(curr.left);
                    burned=true;
                    vis.put(curr.left, 1);
                }

                if(curr.right != null && !vis.containsKey(curr.right)){
                    q.offer(curr.right);
                    burned=true;
                    vis.put(curr.right, 1);
                }

                if(parent.get(curr) != null && !vis.containsKey(parent.get(curr) )){
                    q.offer(parent.get(curr) );
                    burned=true;
                    vis.put(parent.get(curr) , 1);
                }

            }

            if (burned){
                k++;
            }

        }

        return k;
    }
    public int amountOfTime(TreeNode root, int start) {
        if (root == null || (root.left == null && root.right == null)){
            return 0;
        }
        inorder(root, start);
        return BFS(targetNode);
    }
}