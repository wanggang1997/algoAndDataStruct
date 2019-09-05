package com.pers.alan.struct.queue.test;

import com.pers.alan.struct.queue.LoopQueue;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 22:29
 **/
public class TestLoopQueue {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            loopQueue.enQueue(i);
        }
        System.out.println(loopQueue.toString());
        System.out.println("队首："+loopQueue.getFront());
        System.out.println("出队 1:"+loopQueue.deQueue());
        System.out.println(loopQueue.toString());
        System.out.println("入队 1");
        for (int i = 0; i <10 ; i++) {
            loopQueue.enQueue(i);
        }
        System.out.println(loopQueue.toString());

        System.out.println("出队 20");
        for (int i = 0; i < 20 ; i++) {
            loopQueue.deQueue();
        }
        System.out.println(loopQueue.toString());
    }

}
