package com.example.demo.prc.dsimpl;
/*Problem Statement:
        Implement a double-ended queue (abbreviated to deque) that stores strings.
        A deque is a data structure that has characteristics of both a queue and a stack.
        Elements  can be added or removed from either the front or back.

        Signature:
        Create Class Deque*/

public class Deque<T> {

    public static void main(String args[]) {

        Deque<String> dQ = new Deque<String>();

        dQ.addFront("23");
        dQ.addRear("54");
        dQ.addFront("12");
        dQ.addRear("97");
        dQ.display();
        dQ.deleteFront();
        dQ.display();
        dQ.deleteRear();
        dQ.addFront("12");
        dQ.display();
    }

    class Node<T> {
        private T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public T getData() {
            return data;
        }
    }

    private Node<T> front = null, rear = null;

    public void addFront(T data) {
        if (front == null) {
            front = new Node<T>(data);
            rear = front;
        } else {
            front.prev = new Node<T>(data);
            front.prev.next = front;
            front = front.prev;
        }
    }

    public void addRear(T data) {
        if (rear == null) {
            rear = new Node<T>(data);
            front = rear;
        } else {
            rear.next = new Node<T>(data);
            rear.next.prev = rear;
            rear = rear.next;
        }
    }

    public void deleteFront() {
        front = front.next;
        front.prev = null;
    }

    public void deleteRear() {
        rear = rear.prev;
        rear.next = null;
    }

    public T getFront() {
        return front.getData();
    }

    public T getRear() {
        return rear.getData();
    }

    public void display() {

        Node<T> tmp = front;
        System.out.println("Elements in Queue");
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }

    }
}
