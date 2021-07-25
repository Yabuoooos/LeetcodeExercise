package easy;


public class T206ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head.showList();
        ListNode newHead = reverseList(head);
        newHead.showList();
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void showList() {
        ListNode curr = this;
        if (curr == null) {
            System.out.println("null");
        }
        String s = curr.val + "->";
        while (curr.next != null) {
            curr = curr.next;
            s += curr.val + "->";
        }
        s += "null";
        System.out.println(s);
    }
}
