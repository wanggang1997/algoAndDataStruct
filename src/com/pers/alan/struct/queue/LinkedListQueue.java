package com.pers.alan.struct.queue;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-06 11:17
 **/
public class LinkedListQueue<E> implements Queue<E> {
    //头节点 尾节点
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("DeQueue failed.Empty queue.");
        Node res = head;
        head = head.next;
        res.next = null;

        if (head == null)
            tail = null;
        size--;
        return res.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: head [ ");
        Node cur = head;
        //遍历方法1
        /*        for (int i = 0; i < size; i++) {
            res.append(cur).append(" -> ");
            cur = cur.next;
        }*/
        //遍历方法2
        while (cur != null) {
            res.append(cur).append(" -> ");
            cur = cur.next;
        }
        res.append(" NUll ] tail");
        return res.toString();
    }
}
