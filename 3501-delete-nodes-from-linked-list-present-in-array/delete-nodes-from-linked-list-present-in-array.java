/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet(Arrays.asList(nums));
        for(int num : nums){
            set.add(num);
        }
        ListNode cur = new ListNode(0, head);
        ListNode res = cur;
        while(cur.next != null){
            if(set.contains(cur.next.val)){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }

        return res.next;
    }
}