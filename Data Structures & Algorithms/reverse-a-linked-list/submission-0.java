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
    public ListNode reverseList(ListNode head) {
        // 0 -> 1 -> 2 -> 3
        // 

        ListNode current = head;
        ListNode previous = null;

        while (current!=null) {
            //  1 -> 2 -> 3 -> 4
            //       c    tp
            ListNode temp = current.next; // Crio temp
            current.next = previous; // Aponto para tras
            previous = current; // O de tras anda pra frente
            current = temp; // E o current vai pra frente (next.next)
        }

        return previous;
    }
}
