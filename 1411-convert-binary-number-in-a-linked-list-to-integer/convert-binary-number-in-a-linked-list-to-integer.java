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
    public int getDecimalValue(ListNode head) {
        String val = "";
        while(head != null){
            val = val + head.val;
            head = head.next;
        }
                    System.out.println(val);

        int binaryNum = 0;
        int pow = 0;
        int index = val.length() - 1;
        while(index >= 0){
            char lastDig = val.charAt(index--);
            System.out.println(lastDig);
            if(lastDig == '1')
                binaryNum += Math.pow(2, pow);
            pow++;
        }
        return binaryNum;
    }
}