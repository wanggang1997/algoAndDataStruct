package com.pers.alan.struct.heap.test;

import com.pers.alan.struct.heap.MaxHeap;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-18
 **/
public class TestMaxHeap {

    public static void main(String[] args) {

        MaxHeap<Integer>maxHeap = new MaxHeap<>();
        maxHeap.add(5);
        maxHeap.add(8);
        maxHeap.add(7);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(4);
        maxHeap.add(42);
        maxHeap.add(-3);

        for (int i = 0; i < 10; i++) {
            System.out.print(maxHeap.extractMax()+" > ");
        }

        System.out.println();
        Integer[]arr=new Integer[10];
        for (int i = 9; i >=0 ; i--) {
           arr[i]=i+(int)Math.random()*10;
        }

        MaxHeap<Integer>maxHeap1 = new MaxHeap<>(arr);
        System.out.println(maxHeap1.getSize());
        for (int i = 0; i < 10; i++) {
            System.out.print(maxHeap1.extractMax()+">");
        }
    }

}
