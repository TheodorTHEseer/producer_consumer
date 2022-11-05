package com.company;

public class CircularFifoBuffer{ //TODO renew this structure
    private int size;
    private int capacity;

    public CircularFifoBuffer(int capacity){
        this.capacity=capacity;
    }

    Node [] nodes = new Node[10];

    public boolean isFull(){
        return size == (capacity-1);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue (Node node){
        nodes[size]=node;
        nodes[size].body=node.body;
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
