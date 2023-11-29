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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int sum = 0;
        int carry = 0;
        while(l1 != null || l2 != null){
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum > 9 ? sum / 10 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
        if(carry > 0){
            head.next = new ListNode(carry);
            head = head.next;
        }
        return result.next;
    }
}