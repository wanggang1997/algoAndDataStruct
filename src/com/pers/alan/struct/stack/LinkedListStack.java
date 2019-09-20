package com.pers.alan.struct.stack;

import com.pers.alan.struct.linkedlist.LinkedList;

/**
 * @program: algoAndDataStruct
 * @description: 基于链表实现栈
 * @author: wg
 * @create: 2019-09-06 09:59
 **/
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E>linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack : size :%d \n",getSize()));
        res.append("top [ ");
        for (int i = 0; i < linkedList.getSize(); i++) {
            res.append(linkedList.get(i));
            res.append("-> ");
        }
        res.append("NULL ]");
        return res.toString();
    }
}
