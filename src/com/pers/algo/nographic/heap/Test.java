package com.pers.algo.nographic.heap;

import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(10);
        System.out.println(maxHeap.capacity());
        for (int i = 1; i <=maxHeap.capacity() ; i++) {
            int n = (int)(Math.random()*90+10);
            maxHeap.insert(n);
        }
        maxHeap.printMaxHeap();
        System.out.println();
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.extractMax()+" ");
        }
        System.out.println();

        //int [] arr1 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr1={9,8,7,6,5,4,3,2,1,0};
        HeapSort.heapSort1(arr1);
        System.out.print("普通最大堆排序：");
        PrintUtil.printfArrs(arr1);

        //int [] arr2 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr2={9,8,7,6,5,4,3,2,1,0};
        HeapSort.heapSort2(arr2);
        System.out.print("heapify式堆排序：");
        PrintUtil.printfArrs(arr2);

        //int [] arr3 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr3={9,8,7,6,5,4,3,2,1,0};
        InSituHeapSort.insituHeapSort(arr3);
        System.out.print("原地排序：");
        PrintUtil.printfArrs(arr3);
    }

}
