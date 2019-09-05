package com.pers.alan.struct.stack;

import com.pers.alan.struct.array.DynamicArray;

/**
 * @program: algoAndDataStruct
 * @description: 基于数组实现栈
 * @author: wg
 * @create: 2019-09-04 15:55
 **/
public class ArrayStack <E> implements Stack<E>{

    private DynamicArray<E> array;

    public ArrayStack() {
        this.array = new DynamicArray<>();
    }

    public ArrayStack(int capacity) {
        this.array = new DynamicArray<>(capacity);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack: size:%d,capacity:%d\n",getSize(),getCapacity()));
        res.append(" [");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
                if (i!=array.size()-1)
                    res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
