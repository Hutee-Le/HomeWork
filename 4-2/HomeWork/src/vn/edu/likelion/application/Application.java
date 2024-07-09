package vn.edu.likelion.application;

import vn.edu.likelion.lession1.ListNode;

public class Application {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode middle = ListNode.MiddleNode(head);
        System.out.println("The middle node of the list is node " + middle.val);

    }
}
