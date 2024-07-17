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
    boolean[] set = new boolean[1001];
    List<TreeNode> res = new ArrayList();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int d : to_delete){
            set[d] = true;
        }
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode root, boolean flag){
        if(root == null) return root;
        root.left = helper(root.left, set[root.val]);
        root.right = helper(root.right, set[root.val]);
        if(!set[root.val] && flag){
            res.add(root);
        }
        return set[root.val] ? null : root;
    }
}