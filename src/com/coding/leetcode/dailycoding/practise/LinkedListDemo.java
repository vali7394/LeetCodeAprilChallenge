package com.coding.leetcode.dailycoding.practise;/*
  @created 5/16/20
  @Author - Meeravali Shaik
 */

public class LinkedListDemo {
    ListNode head;
    LinkedListDemo(){

    }

    public void addNode(int value){
        ListNode temp = head;
        if(temp==null){
            head = new ListNode(value,null);
            return;
        }
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(value,null);
    }

    public void printLinkedList(ListNode node){
        ListNode temp = node;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public ListNode segregateLinkedList(ListNode node){

        int counter = 1;
        LinkedListDemo oddList = new LinkedListDemo();
        LinkedListDemo evenList = new LinkedListDemo();

        ListNode temp = node;
        while (temp!=null) {
            if (counter % 2 == 0) {
                evenList.addNode(temp.value);
            } else {
                oddList.addNode(temp.value);
            }
            counter++;
            temp = temp.next;
        }
        ListNode oddTemp = oddList.head;
        while (oddTemp.next!=null){
            oddTemp = oddTemp.next ;
        }
        oddTemp.next = evenList.head;
        return oddList.head;
    }

    public static void main(String[] args) {
        LinkedListDemo listDemo = new LinkedListDemo();
        listDemo.addNode(10);
        listDemo.addNode(20);
        listDemo.addNode(30);
        listDemo.addNode(40);
        listDemo.addNode(50);
        ListNode temp = listDemo.segregateLinkedList(listDemo.head);
        listDemo.printLinkedList(temp);
    }



}


class ListNode{
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode() {
    }
}