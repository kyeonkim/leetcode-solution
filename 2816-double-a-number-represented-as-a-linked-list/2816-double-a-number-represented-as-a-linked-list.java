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
    public ListNode doubleIt(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head = prev;
        ListNode result = new ListNode(head.val * 2 % 10, null);
        int roundUp = head.val * 2 / 10;
        prev = result;
        head = head.next;
        while (head != null) {
            result = new ListNode(head.val * 2 % 10 + roundUp, prev);
            roundUp = head.val * 2 / 10;
            prev = result;
            head = head.next;
        }
        if (roundUp != 0)
            result = new ListNode(roundUp, prev);
        return result;
    }
}