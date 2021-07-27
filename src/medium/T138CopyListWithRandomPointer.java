package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T138CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        Node copy = copyRandomList(n1);
        System.out.println(copy);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        List<Node> nodes = new ArrayList<>();
        while (temp != null) {
            nodes.add(new Node(temp.val));
            temp = temp.next;
        }
        //设置每个节点的next节点
        int size = nodes.size();
        for (int i = 0; i < size - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        //设置每个节点的random节点
        temp = head;
        for (int i = 0; i < size; i++) {
            int count = 1;
            if (temp.random != null) {
                Node rd = temp.random;
                while (rd.next != null) {
                    count++;
                    rd = rd.next;
                }
                nodes.get(i).random = nodes.get(size - count);
            }
            temp = temp.next;
        }

        return nodes.get(0);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
