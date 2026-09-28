class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode output = head;

        int size = 0;
        ListNode current = head;

        // Descobrir o tamanho
        while (current != null) {
            current = current.next;
            size++;
        }

        // Se precisa remover o primeiro nó
        if (n == size) {
            return head.next;
        }

        // Voltar para o começo
        current = head;

        int target = size - n + 1;
        int counter = 1;

        ListNode previous = null;

        while (current != null) {

            if (counter == target) {
                previous.next = current.next;
                break;
            }

            previous = current;
            current = current.next;
            counter++;
        }

        return output;
    }
}