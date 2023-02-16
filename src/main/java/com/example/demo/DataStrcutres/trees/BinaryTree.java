package com.example.demo.DataStrcutres.trees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int key;
    Node left;
    Node right;
    Node(int key){
        this.key = key;
    }
}
public class BinaryTree {
    static Node root;
    public void add(int value){
        root = addRecursive(root,value);
    }

    private Node addRecursive(Node current, int value) {
        if(current==null){
            return new Node(value);
        }
        if(value<current.key){
            current.left = addRecursive(current.left,value);
        } else if (value>current.key){
            current.right = addRecursive(current.right,value);
        }
        else{
            //If the value alreadhy contains in the tree we just return the current node;
            return current;
        }
        return current;
    }
    private Node deleteRecursive(Node current,int value){
        if(current==null){
            return null;
        }
        if(value == current.key){
            if(current.left==null && current.right==null){
                return null;
            }
            if(current.left==null){
                return current.right;
            }
            if(current.right==null){
                return current.left;
            }
            int smallestValue = findSmallestValue(current.right);
            current.key = smallestValue;
            current.right = deleteRecursive(current.right,smallestValue);
            return current;
        }
        if(value<current.key){
            current.left = deleteRecursive(current.left,value);
            return current;
        }
        current.right = deleteRecursive(current.right,value);
        return current;

    }

    private int findSmallestValue(Node right) {
        return right.left==null ? right.key : findSmallestValue(right.left);
    }

    public void delete(int value){
        root = deleteRecursive(root,value);
    }
    public static BinaryTree createBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(2);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }
    public static void printNodeAtKDis(Node curr,int k){
        if(curr==null){
            return;
        }
        if (k == 0) {
            System.out.print(curr.key + "\t");
        }
        else{
            printNodeAtKDis(curr.left,k-1);
            printNodeAtKDis(curr.right,k-1);
        }
    }
    public static void main(String[] args){
        createBinaryTree();
        inOrder(root);
        System.out.println("PostOrder:");
        postOrder(root);
        System.out.println("PreOrder:");
        preOrder(root);
        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.delete(6);
        System.out.println("PreOrder:");
        preOrder(root);
        System.out.println("Level Order Traversal:");
        printLevelOrder(root);
        System.out.println("Height of the tree is :");
        System.out.println(heightOfTree(root));
        System.out.println("Nodes at distance 0");
        printNodeAtKDis(root,0);
        System.out.println("Level Order Traversal:");
        printLevelOrderNaiveApproach(root);

    }
    public static int heightOfTree(Node current){
        if(current==null){
            return 0;
        }
        else{
            return Math.max(heightOfTree(current.left),heightOfTree(current.right))+1;
        }
    }
    public static  void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.key+"\t");
            inOrder(root.right);
        }
    }
    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.key+"\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+"\t");
        }
    }

    //This Method uses the concept of Queue.. for print Level Order Traversal
    public static void printLevelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.key+"\t");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }
    public static void printLevelOrderNaiveApproach(Node curr){
        int height = heightOfTree(curr);
        for(int i=0 ; i<height ; i++){
            printNodeAtKDis(curr,i);
        }
    }
}
