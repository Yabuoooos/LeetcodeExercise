package medium;

public class T92ReverseListⅡ {
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
        reverseBetween(head, 2, 4).showList();


    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        //记录链表总长度
        int size = 0;
        ListNode count = head;
        while (count != null) {
            count = count.next;
            size++;
        }
        if (left == 1 && right == size) {
            return reverse(head);
        } else if (left == 1) {
            ListNode curr = head;
            for (int i = 0; i < right - 1; i++) {
                curr = curr.next;
            }
            ListNode temp = curr.next;
            curr.next = null;
            ListNode res = reverse(head);
            head.next = temp;
            return res;
        } else {
            ListNode curr = head;
            for (int i = 0; i < left - 2; i++) {
                curr = curr.next;
            }
            ListNode temp = curr.next;
            curr.next = null;
            if (right == size) {
                ListNode res = reverse(temp);
                curr.next = res;
                return head;
            } else {
                ListNode end = temp;
                for (int i = 0; i < right - left; i++) {
                    end = end.next;
                }
                ListNode rightPart = end.next;
                end.next = null;
                ListNode res = reverse(temp);
                curr.next = res;
                while (res.next != null) {
                    res = res.next;
                }
                res.next = rightPart;
                return head;
            }
        }
    }

    private static ListNode reverse(ListNode head) {
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
