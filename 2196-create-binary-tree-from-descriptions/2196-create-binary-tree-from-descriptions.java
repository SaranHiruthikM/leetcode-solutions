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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] desc : descriptions){
            int parent = desc[0];
            int child = desc[1];
            TreeNode parNode;
            TreeNode childNode;
            if(map.containsKey(parent)){
                parNode = map.get(parent);
            }else{
                parNode = new TreeNode(parent);
                map.put(parent, parNode);
            }

            if(map.containsKey(child)){
                childNode = map.get(child);
            }else{
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            if(desc[2] == 1){
                parNode.left = childNode;
            }else{
                parNode.right = childNode;
            }
            set.add(childNode.val);
        }

        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()){
            if(!set.contains(entry.getKey())){
                return entry.getValue();
            }
        }

        return null;
    }
}