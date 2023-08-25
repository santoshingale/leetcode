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
    class Pair{
        int num;
        TreeNode node;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        int maxLen = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                int curId = q.peek().num - min;
                Pair cur = q.poll();
                if(i == 0)
                    first = cur.num;
                else if(i == size - 1)
                    last = cur.num;

                if(cur.node.left != null){
                    q.add(new Pair(cur.node.left, (curId * 2) + 1));
                }
                if(cur.node.right != null){
                    q.add(new Pair(cur.node.right, (curId * 2) + 2));
                }
                
            }
            maxLen = Math.max(maxLen, last - first + 1);
        }
        return maxLen;
    }
}