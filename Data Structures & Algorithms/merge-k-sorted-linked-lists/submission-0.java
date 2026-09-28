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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(0);
        ListNode output = head;
        while (head!=null) {
            ListNode next = findMinListNode(lists);
            head.next = next;
            head = head.next;
        }
        // For loop into the k lists;
        // Find the next node to be pointed at;
        // 
        return output.next;
    }

private ListNode findMinListNode(ListNode[] lists) {

    ListNode minNode = null;
    int minIndex = -1;

    for (int i = 0; i < lists.length; i++) {

        if (lists[i] == null) {
            continue;
        }

        if (minNode == null || lists[i].val < minNode.val) {
            minNode = lists[i];
            minIndex = i;
        }
    }

    // Remove o menor da lista original
    if (minNode != null) {
        lists[minIndex] = lists[minIndex].next;
    }

    return minNode;
}
}
