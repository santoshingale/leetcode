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
    Map<String, Integer> map;
    List<TreeNode> nodeList;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap();
        nodeList = new ArrayList();
        helper(root);
        return nodeList;
    }

    private String helper(TreeNode root){
        if(root == null) return "null";
        String left = helper(root.left);
        String right = helper(root.right);
        String path = root.val+"," + left+"," + right;
        map.put(path, map.getOrDefault(path, 0) + 1);
        if(map.get(path) == 2){
            nodeList.add(root);
        }
        return path;
    }
}