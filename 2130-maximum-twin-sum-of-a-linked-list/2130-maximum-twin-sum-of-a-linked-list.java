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
    public int pairSum(ListNode head) {
        if(head == null||head.next == null)
        {
            return 0;
        }
        ListNode slow = head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode shalf = reverseList(slow);
        int max = 0;
        ListNode fhalf = head;
        while(shalf!=null)
        {
            max=Math.max(max,fhalf.val+shalf.val);
            fhalf = fhalf.next;
            shalf = shalf.next;
        }
        return max;
    }
        private ListNode reverseList(ListNode head)
        {
            ListNode prev = null;
            ListNode curr = head;
            while(curr!=null)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
}