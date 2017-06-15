/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/
// https://www.hackerrank.com/challenges/ctci-linked-list-cycle/submissions/code/46541818
boolean hasCycle(Node head) {
    if (head == null) return false;
    
    Node current = head;
    Node next = head.next;
    while (current != next) {
        if (next == null || next.next == null) return false;
        // first to check if head and next node are null, 
        // then just need to check if head and next.next are the same
        current = current.next;
        next = next.next.next;
    }
    return true;
}
