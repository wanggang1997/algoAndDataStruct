package com.pers.algo.nographic.heap;

import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {

    public static void main(String[] args) throws Exception {

        //int [] arr1 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr1={9,8,2,6,5,4,7,3,1,7,0};
        HeapSort.heapSort1(arr1);
        System.out.print("普通最大堆排序：");
        PrintUtil.printfArrs(arr1);

        //int [] arr2 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr2={9,8,2,6,5,4,7,3,1,7,0};
        HeapSort.heapSort2(arr2);
        System.out.print("heapify式堆排序：");
        PrintUtil.printfArrs(arr2);

        //int [] arr3 = GenerateArrayUtil.generateRandomArray(10,0,10);
        int [] arr3={9,8,2,6,5,4,7,3,1,7,0};
        InSituHeapSort.insituHeapSort(arr3);
        System.out.print("原地排序：");
        PrintUtil.printfArrs(arr3);

        int [] arr4={9,8,2,6,5,4,7,3,1,7,0};
        HeapSort.heapSortIndex(arr4);
        System.out.print("最大索引堆：");
        PrintUtil.printfArrs(arr4);

    }

}
