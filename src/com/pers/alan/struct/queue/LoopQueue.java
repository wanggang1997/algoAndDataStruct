package com.pers.alan.struct.queue;

/**
 * @program: algoAndDataStruct
 * @description: 循环队列的实现
 * @author: wg
 * @create: 2019-09-04 19:42
 **/
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    //front:指向队首元素  tail：指向队尾下一个元素
    // 当front==tail时 队列为空  （tail +1） % (capacity + 1）==front 队列满
    private int front, tail;
    //可见容量  data的实际长度为capacity+1 其中长度1的空间用于判断都循环队列满情况
    private int capacity;
    private int size;

    public LoopQueue(int capacity) {
        this.capacity = capacity;
        data = (E[])new Object[this.capacity+1];
        front= tail =0;
        size=0;
    }

    public LoopQueue() {
        this(10);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getCapacity(){
        return capacity;
    }

    @Override
    public void enQueue(E e) {
        //tail 始终指向队尾的下一个空元素
        //注意维护tail的定义
        if ((tail +1) % (capacity+1) == front)
            resize(capacity<<1);
        data[tail] = e;
        tail = (tail +1) % (capacity+1);
        size++;
    }

    @Override
    public E deQueue() {
        //front 始终指向队首
        if (isEmpey())
            throw new IllegalArgumentException("DeQueue failed.The queue is empty.");
        E frontE = data[front];
        data[front] = null;
        front = (front+1) % (capacity+1);
        size--;
        if (size==capacity>>2)
            resize(capacity>>1);
        return frontE;
    }

    /*/**
     * @title
     * @description 循环队列的扩容
     * @author wg
     * @param: capacityN
     * @updateTime 2019/9/4 21:02
     * @throws
     */
    private void resize(int capacityN) {
        E[] newData =(E[]) new Object[ capacityN+1 ];
        for (int i = 0; i < size; i++)
            //front指向队首元素
            newData[i] = data[ (i+front) % (capacity+1) ];
        capacity = capacityN;
        data = newData;
        front=0;
        tail=size;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public boolean isEmpey() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue :size = %d,capacity = %d\n ",size,capacity));
        res.append("front [ ");
        for (int i = front; i < tail; i=(i+1)%(capacity+1)) {
            res.append(data[i]);
            if ((i+1)%(capacity+1)!=tail)
                res.append(", ");
        }
        res.append(" ]tail");
        return res.toString();
    }
}
