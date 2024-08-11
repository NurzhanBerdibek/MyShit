public class Swapping {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return Swapper(head);

    }

    public static ListNode Swapper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        ListNode temp2 = temp.next;
        head.next = temp2;
        temp.next = head;
        head = temp;
        temp = temp.next;
        System.out.println(head);
        System.out.println(temp);
        System.out.println(temp2);
        System.out.println(temp2.next);
        System.out.println("Cycle end");
        temp.next = Swapper(temp2);
        return head;
    }

    public static void main(String[] args) {
        // Construct the linked list [1, 2, 3, 4]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Call the swapPairs method
        head = swapPairs(head);
    }
}
