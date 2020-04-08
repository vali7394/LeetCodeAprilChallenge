package com.coding.leetcode.challenge.april.week2;/*
  @created 4/8/20
  @Author  Meeravali Shaik
 */


/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 */

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        System.out.println(findMiddleNode(prepareLinkedList(5)).value);
        System.out.println(findMiddleNode(prepareLinkedList(6)).value);
        System.out.println(findMiddleNode(prepareLinkedList(0)).value);
    }


    private static ListNode findMiddleNode(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode current = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            current = current.next;
        }

        return current;
    }

    private static ListNode prepareLinkedList(int size){
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode next = null;
        for(int i=1;i<size;i++){
            next = new ListNode(i);
            current.next = next;
            current = current.next;
        }

        ListNode temp = head;
       /* while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }*/

        return head;
    }


}


class ListNode {
    int value;
    ListNode next;


    public ListNode(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
