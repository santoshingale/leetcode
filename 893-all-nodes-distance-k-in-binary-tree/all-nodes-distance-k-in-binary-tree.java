/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> pMap = new HashMap();
        parentMark(root, pMap);
        Queue<TreeNode> q = new LinkedList();
        Map<TreeNode, Boolean> visited = new HashMap();
        q.add(target);
        visited.put(target, true);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null && visited.get(cur.left) == null){
                    q.add(cur.left);
                    visited.put(cur.left, true);
                }
                if(cur.right != null && visited.get(cur.right) == null){
                    q.add(cur.right);
                    visited.put(cur.right, true);
                }

                if(pMap.get(cur) != null && visited.get(pMap.get(cur)) == null){
                    q.add(pMap.get(cur));
                    visited.put(pMap.get(cur), true);
                }
            }
            level++;

        }
        List<Integer> result = new ArrayList();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }

    private void parentMark(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                q.add(cur.left);
                map.put(cur.left, cur);
            }
            if(cur.right != null){
                q.add(cur.right);
                map.put(cur.right, cur);
            }
        }
    }
}