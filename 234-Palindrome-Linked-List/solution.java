/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode mid = findMid(head);
        mid.next  = reverse(mid.next);
        ListNode l1 = head, l2 = mid.next;
        while(l1 != null && l2 != null && l1.val == l2.val) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2 == null;
    }
    
    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}