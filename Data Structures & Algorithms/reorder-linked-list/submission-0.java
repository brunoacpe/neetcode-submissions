class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode[] split = splitLinkedList(head);

        ListNode first = split[0];
        ListNode second = reverseLinkedList(split[1]);

        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode[] splitLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        return new ListNode[]{head, second};
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}