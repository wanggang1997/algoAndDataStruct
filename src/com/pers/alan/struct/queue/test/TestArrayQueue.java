package com.pers.alan.struct.queue.test;

import com.pers.alan.struct.queue.ArrayQueue;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 19:19
 **/
public class TestArrayQueue {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue.toString());

        System.out.println("队首:"+queue.getFront());
        System.out.println("出队:"+queue.deQueue());
        System.out.println(queue.toString());

        System.out.println("size:"+queue.getSize());
        System.out.println("capacity:"+queue.getCapacity());
    }
}
