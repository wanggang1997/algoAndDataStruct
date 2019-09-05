package com.pers.alan.struct.linkedlist;


/**
 * @program: algoAndDataStruct
 * @description: 链表
 * @author: wg
 * @create: 2019-09-05 09:27
 **/
public class LinkedList<E> {

    private class Node<E>{
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
