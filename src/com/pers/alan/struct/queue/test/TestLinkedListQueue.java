package com.pers.alan.struct.queue.test;

import com.pers.alan.struct.queue.LinkedListQueue;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-06 14:25
 **/
public class TestLinkedListQueue {


    public static void main(String[] args) {
        LinkedListQueue<Integer>linkedListQueue = new LinkedListQueue<>();
        System.out.println(linkedListQueue.toString());
        for (int i = 10; i >0 ; i--) {
            linkedListQueue.enQueue(i);
        }
        System.out.println(linkedListQueue.toString());
        System.out.println(linkedListQueue.deQueue());
        System.out.println(linkedListQueue.toString());

    }

}
