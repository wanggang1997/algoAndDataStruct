package com.pers.alan.struct.queue;

public interface Queue <E>{

    //入队
    void enQueue(E e);
    //出队
    E deQueue();
    //获取队首
    E getFront();
    //判空
    boolean isEmpty();
    //获取队长
    int getSize();

}
