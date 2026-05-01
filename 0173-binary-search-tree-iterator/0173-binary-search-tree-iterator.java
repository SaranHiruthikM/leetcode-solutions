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
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();

    public void storeLeftNodes(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        storeLeftNodes(root);
    }
    
    public int next() {
        TreeNode ans = s.pop();

        
            storeLeftNodes(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return s.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */