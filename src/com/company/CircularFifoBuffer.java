package com.company;

public class CircularFifoBuffer{
    private int size;
    private int capacity;

    public CircularFifoBuffer(int capacity){
        this.capacity=capacity;
    }

    public CircularFifoBuffer(){
    }

    class Node{
        String body;
        Node next;
    }

    Node [] nodes=(Node[]) new Object[capacity];

    public boolean isFull(){
        return size == (capacity-1);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue (String node){
        nodes[size]=(Node) new Object();
        nodes[size].body=node;
        nodes[size].next=null;
        if (size > 0 && !isFull()){
            nodes[size-1].next=nodes[size];
        }
        if (isFull()) {
            nodes[size - 1] = nodes[0];
            dequeue();
        }
    }

    public String dequeue(){
        Node temp = nodes[size];
        nodes[size].body=null;
        nodes[size--] = null;
        return temp.body;
    }

}
