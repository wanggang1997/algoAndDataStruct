package com.pers.algo.nographic.testtc;

import com.pers.algo.nographic.heap.HeapSort;
import com.pers.algo.nographic.heap.InSituHeapSort;
import com.pers.algo.nographic.insert.ShellIns;
import com.pers.algo.nographic.merge.MergeIns;
import com.pers.algo.nographic.quick.QuickSort1Way;
import com.pers.algo.nographic.quick.QuickSort2Ways;
import com.pers.algo.nographic.quick.QuickSort3Ways;
import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {

    public static void main(String[] args) {
        //无序
        int []arro1 = GenerateArrayUtil.generateRandomArray(1000000,0,1000000);

        int []arro2 = GenerateArrayUtil.copyArray(arro1);

        int []arro3 = GenerateArrayUtil.copyArray(arro1);

        int []arro4 = GenerateArrayUtil.copyArray(arro1);

        int []arro5 = GenerateArrayUtil.copyArray(arro1);

        int []arro6 = GenerateArrayUtil.copyArray(arro1);

        int []arro7 = GenerateArrayUtil.copyArray(arro1);

        int []arro8 = GenerateArrayUtil.copyArray(arro1);

        int []arro9 = GenerateArrayUtil.copyArray(arro1);

        int []arro10 = GenerateArrayUtil.copyArray(arro1);

        int []arro11 = GenerateArrayUtil.copyArray(arro1);

        int []arro12 = GenerateArrayUtil.copyArray(arro1);

        //近乎有序
        int []arru1 = GenerateArrayUtil.generateNearlyOrderedArray(1000000,100);

        int []arru2 = GenerateArrayUtil.copyArray(arru1);

        int []arru3 = GenerateArrayUtil.copyArray(arru1);

        int []arru4 = GenerateArrayUtil.copyArray(arru1);

        int []arru5 = GenerateArrayUtil.copyArray(arru1);

        int []arru6 = GenerateArrayUtil.copyArray(arru1);

        int []arru7 = GenerateArrayUtil.copyArray(arru1);

        int []arru8 = GenerateArrayUtil.copyArray(arru1);

        int []arru9 = GenerateArrayUtil.copyArray(arru1);

        int []arru10 = GenerateArrayUtil.copyArray(arru1);

        int []arru11 = GenerateArrayUtil.copyArray(arru1);

        int []arru12 = GenerateArrayUtil.copyArray(arru1);

        //无序且小范围
        int []arrs1 = GenerateArrayUtil.generateRandomArray(1000000,0,10);

        int []arrs2 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs3 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs4 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs5 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs6 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs7 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs8 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs9 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs10 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs11 = GenerateArrayUtil.copyArray(arrs1);

        int []arrs12 = GenerateArrayUtil.copyArray(arrs1);

      /*  //选择排序测试
        long startTime_o1=System.nanoTime();
        SelectionSort.selSort(arro1);
        long endTime_o1=System.nanoTime();
        PrintUtil.printRunTime("选择排序:随机无序,时间为",startTime_o1,endTime_o1);
        //
        long startTime_u1=System.nanoTime();
        SelectionSort.selSort(arru1);
        long endTime_u1=System.nanoTime();
        PrintUtil.printRunTime("选择排序:近乎有序,时间为",startTime_u1,endTime_u1);
        System.out.println("*********************");


         //原始插入排序测试
        long startTime_o2=System.nanoTime();
        OrignIns.oriInsSort(arro2);
        long endTime_o2=System.nanoTime();
        PrintUtil.printRunTime("原始插入排序:随机无序,时间为",startTime_o2,endTime_o2);
        //
        long startTime_u2=System.nanoTime();
        OrignIns.oriInsSort(arru2);
        long endTime_u2=System.nanoTime();
        PrintUtil.printRunTime("原始插入排序:近乎有序,时间为",startTime_u2,endTime_u2);
        System.out.println("*********************");


        //优化插入排序测试
        long startTime_o3=System.nanoTime();
        OptimizedIns.optInsSort(arro3);
        long endTime_o3=System.nanoTime();
        PrintUtil.printRunTime("化插入排序:随机无序,时间为",startTime_o3,endTime_o3);
        */

/*
        //
        long startTime_u3=System.nanoTime();
        OptimizedIns.optInsSort(arru3);
        long endTime_u3=System.nanoTime();
        PrintUtil.printRunTime("优化插入排序排序:近乎有序,时间为",startTime_u3,endTime_u3);
        System.out.println("*********************");
*/


        //希尔排序测试
        long startTime_o4=System.nanoTime();
        ShellIns.shellSort2(arro4);
        long endTime_o4=System.nanoTime();
        PrintUtil.printRunTime("希尔排序:随机无序,时间为",startTime_o4,endTime_o4);
        //
        long startTime_u4=System.nanoTime();
        ShellIns.shellSort2(arru4);
        long endTime_u4=System.nanoTime();
        PrintUtil.printRunTime("希尔排序:近乎有序,时间为",startTime_u4,endTime_u4);
        //
        long startTime_s4=System.nanoTime();
        ShellIns.shellSort2(arrs4);
        long endTime_s4=System.nanoTime();
        PrintUtil.printRunTime("希尔排序:无序小范围,时间为",startTime_s4,endTime_s4);
        System.out.println("*********************");

        //归并排序测试
        long startTime_o5=System.nanoTime();
        MergeIns.mergeSort(arro5);
        long endTime_o5=System.nanoTime();
        PrintUtil.printRunTime("归并排序:随机无序,时间为",startTime_o5,endTime_o5);
        //
        long startTime_u5=System.nanoTime();
        MergeIns.mergeSort(arru5);
        long endTime_u5=System.nanoTime();
        PrintUtil.printRunTime("归并排序:近乎有序,时间为",startTime_u5,endTime_u5);
        //
        long startTime_s5=System.nanoTime();
        MergeIns.mergeSort(arrs5);
        long endTime_s5=System.nanoTime();
        PrintUtil.printRunTime("归并排序:无序小范围,时间为",startTime_s5,endTime_s5);
        System.out.println("*********************");


        //快速排序1way测试
        long startTime_o6=System.nanoTime();
        QuickSort1Way.quickSort1Way(arro6);
        long endTime_o6=System.nanoTime();
        PrintUtil.printRunTime("快速排序1way:随机无序,时间为",startTime_o6,endTime_o6);
        //
        long startTime_u6=System.nanoTime();
        QuickSort1Way.quickSort1Way(arru6);
        long endTime_u6=System.nanoTime();
        PrintUtil.printRunTime("快速排序1way:近乎有序,时间为",startTime_u6,endTime_u6);
        //
/*        long startTime_s6=System.nanoTime();
        QuickSort1Way.quickSort1Way(arrs6);
        long endTime_s6=System.nanoTime();
        PrintUtil.printRunTime("快速排序1way:无序小范围,时间为",startTime_s6,endTime_s6);*/
        System.out.println("*********************");


        //快速排序2way测试
        long startTime_o7=System.nanoTime();
        QuickSort2Ways.quickSort2Ways(arro7);
        long endTime_o7=System.nanoTime();
        PrintUtil.printRunTime("快速排序2way:随机无序,时间为",startTime_o7,endTime_o7);
        //
        long startTime_u7=System.nanoTime();
        QuickSort2Ways.quickSort2Ways(arru7);
        long endTime_u7=System.nanoTime();
        PrintUtil.printRunTime("快速排序2way:近乎有序,时间为",startTime_u7,endTime_u7);
        //
        long startTime_s7=System.nanoTime();
        QuickSort2Ways.quickSort2Ways(arrs7);
        long endTime_s7=System.nanoTime();
        PrintUtil.printRunTime("快速排序2way:无序小范围,时间为",startTime_s7,endTime_s7);
        System.out.println("*********************");

        //快速排序3way测试
        long startTime_o8=System.nanoTime();
        QuickSort3Ways.quickSort3Ways(arro8);
        long endTime_o8=System.nanoTime();
        PrintUtil.printRunTime("快速排序3way:随机无序,时间为",startTime_o8,endTime_o8);
        //
        long startTime_u8=System.nanoTime();
        QuickSort3Ways.quickSort3Ways(arru8);
        long endTime_u8=System.nanoTime();
        PrintUtil.printRunTime("快速排序3way:近乎有序,时间为",startTime_u8,endTime_u8);
        //
        long startTime_s8=System.nanoTime();
        QuickSort3Ways.quickSort3Ways(arrs8);
        long endTime_s8=System.nanoTime();
        PrintUtil.printRunTime("快速排序3way:无序小范围,时间为",startTime_s8,endTime_s8);
        System.out.println("*********************");

        //堆排序1测试
        long startTime_o9=System.nanoTime();
        HeapSort.heapSort1(arro9);
        long endTime_o9=System.nanoTime();
        PrintUtil.printRunTime("最大堆堆排序:随机无序,时间为",startTime_o9,endTime_o9);
        //
        long startTime_u9=System.nanoTime();
        HeapSort.heapSort1(arru9);
        long endTime_u9=System.nanoTime();
        PrintUtil.printRunTime("最大堆堆排序:近乎有序,时间为",startTime_u9,endTime_u9);
        //
        long startTime_s9=System.nanoTime();
        HeapSort.heapSort1(arrs9);
        long endTime_s9=System.nanoTime();
        PrintUtil.printRunTime("最大堆堆排序:无序小范围,时间为",startTime_s9,endTime_s9);
        System.out.println("*********************");

        //堆排序heapify测试
        long startTime_o10=System.nanoTime();
        HeapSort.heapSort2(arro10);
        long endTime_o10=System.nanoTime();
        PrintUtil.printRunTime("heapify堆排序:随机无序,时间为",startTime_o10,endTime_o10);
        //
        long startTime_u10=System.nanoTime();
        HeapSort.heapSort2(arru10);
        long endTime_u10=System.nanoTime();
        PrintUtil.printRunTime("heapify堆排序:近乎有序,时间为",startTime_u10,endTime_u10);
        //
        long startTime_s10=System.nanoTime();
        HeapSort.heapSort2(arrs10);
        long endTime_s10=System.nanoTime();
        PrintUtil.printRunTime("heapify堆排序:无序小范围,时间为",startTime_s10,endTime_s10);
        System.out.println("*********************");

        //堆排序heapify测试
        long startTime_o11=System.nanoTime();
        InSituHeapSort.insituHeapSort(arro11);
        long endTime_o11=System.nanoTime();
        PrintUtil.printRunTime("原地堆排序:随机无序,时间为",startTime_o11,endTime_o11);
        //
        long startTime_u11=System.nanoTime();
        InSituHeapSort.insituHeapSort(arru11);
        long endTime_u11=System.nanoTime();
        PrintUtil.printRunTime("原地堆排序:近乎有序,时间为",startTime_u11,endTime_u11);
        //
        long startTime_s11=System.nanoTime();
        InSituHeapSort.insituHeapSort(arrs11);
        long endTime_s11=System.nanoTime();
        PrintUtil.printRunTime("原地堆排序:无序小范围,时间为",startTime_s11,endTime_s11);
        System.out.println("*********************");
    }

}
