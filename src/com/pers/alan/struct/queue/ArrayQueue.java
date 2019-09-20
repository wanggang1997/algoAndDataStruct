package com.pers.alan.struct.queue;

import com.pers.alan.struct.array.DynamicArray;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 19:13
 **/
public class ArrayQueue <E> implements Queue<E> {
    private DynamicArray<E>array;

    public ArrayQueue() {
        this.array = new DynamicArray<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new DynamicArray<>(capacity);
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size:%d,capacity:%d\n",getSize(),getCapacity()));
        res.append(" front [ ");
        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
                if (i!=array.size()-1)
                    res.append(", ");
        }
        res.append(" ]");
        return res.toString();
    }
}
