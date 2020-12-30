package com.demo.dat.structure;


/**
 * 链表环问题
 *
 * 第二次相遇走的步数即为环长
 * 而找到环形的入环点的的方式：
 * 首此相遇以后，一个指针退回到入口，快慢指针都退化到慢指针，然后相遇点即为环形入口点
 */
public class LinkCycle {

    public static void main(String[] args) {

        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(1);
        Node n5 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        System.out.println("############# isCycle " + isCycle(n1));
    }

    private static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
