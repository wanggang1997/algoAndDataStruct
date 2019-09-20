package com.pers.alan.struct.queue;

import com.pers.alan.struct.heap.MaxHeap;

/**
 * @program: algoAndDataStruct
 * @description:优先队列 此处使用最大堆实现
 * @author: wg
 * @create: 2019-09-19
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E>maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public int getSize(){
        return maxHeap.getSize();
    }
}
