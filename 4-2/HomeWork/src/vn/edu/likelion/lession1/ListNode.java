package vn.edu.likelion.lession1;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode MiddleNode(ListNode head) {
        if (head == null) return null;

        ListNode firstNode = head;
        ListNode secondNode = head;

        while (secondNode != null && secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }
        return firstNode;
    }
}
