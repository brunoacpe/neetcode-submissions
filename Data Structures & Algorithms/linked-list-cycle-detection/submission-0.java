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
    public boolean hasCycle(ListNode head) {
        
        HashMap<ListNode, Boolean> seen = new HashMap<>();

        while (head!=null) {
            if(!seen.containsKey(head)) {
                seen.put(head, true);
                ListNode next = head.next;
                head = next;
            } else {
                return true;
            }
        }
        return false;
    }
}
