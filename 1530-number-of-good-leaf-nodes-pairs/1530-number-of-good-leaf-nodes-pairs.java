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
    int goodPairs = 0;

    private List<Integer> dfs(TreeNode root,int distance){
        if(root == null){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null){
            List<Integer> res = new ArrayList<>();
            res.add(1);
            return res;
        }

        List<Integer> left_d = dfs(root.left, distance);
        List<Integer> right_d = dfs(root.right, distance);

        for(int l : left_d){
            for(int r : right_d){
                if(l + r <= distance){
                    goodPairs++;
                }
            }
        }
        List<Integer> curr = new ArrayList<>();
        for(int l : left_d){
            if(l+1 <= distance){
                curr.add(l+1);
            }
        }

        for(int r : right_d){
            if(r+1 <= distance){
                curr.add(r+1);
            }
        }

        return curr;
    }
    
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return goodPairs;
    }
}