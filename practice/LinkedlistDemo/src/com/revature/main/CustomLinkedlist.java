package com.revature.main;

public class CustomLinkedlist {
    Node head;
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data =data;
            next=null;
        }}
        public void PrintData(){
            Node n= head;
            while(n !=null){
                System.out.println(n.data);
                n=n.next;
            }

    }
        public static void main(String[] args) {
        CustomLinkedlist l1 =new CustomLinkedlist();
        Node first = l1.new Node(10);
        l1.head =first ;

        Node second =l1.new Node(20);
            first.next=second;
            Node third =l1.new Node(30);
            second.next=third;

         l1.PrintData();

    }
}
