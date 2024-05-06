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
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        ListNode result = null;
        head = prev;
        while (head != null) {
            if (result == null || result.val <= head.val) {
                ListNode temp = result;
                result = new ListNode(head.val, temp);
            }
            head = head.next;
        }
        return result;
    }
}