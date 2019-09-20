package com.pers.alan.struct.queue.test;

import com.pers.alan.algo_struct.utils.PrintUtil;
import com.pers.alan.struct.queue.LinkedListQueue;
import com.pers.alan.struct.queue.LoopQueue;
import com.pers.alan.struct.queue.Queue;

import java.util.Random;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 22:56
 **/
public class Test {
    private static  Random random = new Random();
    private static  void testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            q.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.deQueue();
        }
        long endTime = System.nanoTime();
        PrintUtil.printRunTime(q.getClass().getSimpleName(), startTime, endTime);
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        //ArrayQueue<Integer>arrayQueue = new ArrayQueue<>();
        //testQueue(arrayQueue,opCount);
        LoopQueue<Integer>loopQueue = new LoopQueue<>();
        testQueue(loopQueue,opCount);
        LinkedListQueue<Integer>linkedListQueue = new LinkedListQueue<>();
        testQueue(linkedListQueue,opCount);
    }
}
