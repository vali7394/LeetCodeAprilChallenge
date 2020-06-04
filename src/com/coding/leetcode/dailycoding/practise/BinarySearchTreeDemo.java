package com.coding.leetcode.dailycoding.practise;/*
  @created 5/20/20
  @Author  - Meeravali Shaik
 */

public class BinarySearchTreeDemo {

    BstNode root;

    public static void main(String[] args) {
        BinarySearchTreeDemo treeDemo = new BinarySearchTreeDemo();
        treeDemo.addElement(10);
        treeDemo.addElement(7);
        treeDemo.addElement(15);
        treeDemo.addElement(13);
        treeDemo.addElement(17);
        treeDemo.addElement(5);
        treeDemo.addElement(8);
       // treeDemo.printInOrderBstNode(treeDemo.root);
       treeDemo.printPreBstNode(treeDemo.root);
      //  treeDemo.printPostBstNode(treeDemo.root);
    }

    public void addElement(int value){
        root = addNode(root,value);
    }


    private BstNode addNode(BstNode bstNode , int value){
        if(bstNode == null){
            return  new BstNode(value);
        }
        if(bstNode.value < value){
            bstNode.right = addNode(bstNode.right,value);
            return bstNode;
        }
            bstNode.left = addNode(bstNode.left,value);
        return bstNode;
    }

    private void printInOrderBstNode(BstNode node){
        if(node==null){
            return;
        }

        printInOrderBstNode(node.left);
        System.out.println(node.value);
        printInOrderBstNode(node.right);
    }

    private void printPreBstNode(BstNode node){
        if(node==null){
            return;
        }

        System.out.println(node.value);
        printPreBstNode(node.left);
        printPreBstNode(node.right);
    }

    private void printPostBstNode(BstNode node){
        if(node==null){
            return;
        }
        printPostBstNode(node.left);
        printPostBstNode(node.right);
        System.out.println(node.value);
    }


}


class BstNode{

    int value;
    BstNode left;
    BstNode right;

    public BstNode(int value) {
        this.value = value;
    }
}