package com.pers.algo.nographic.insert;

import com.pers.algo.nographic.util.FibonacciUtil;
import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {

    public static void main(String[] args) {

        int []arr1 = GenerateArrayUtil.generateRandomArray(100,0,100);

        int []arr2 = GenerateArrayUtil.copyArray(arr1);

        int []arr3 = GenerateArrayUtil.copyArray(arr1);

        int []arr4 = GenerateArrayUtil.copyArray(arr1);

        int []arr5 = GenerateArrayUtil.copyArray(arr1);


        OrignIns.oriInsSort(arr1);
        System.out.print("原始的插入排序");
        PrintUtil.printfArrs(arr1);


        OptimizedIns.optInsSort(arr2);
        System.out.print("优化后的插入排序");
        PrintUtil.printfArrs(arr2);

        ShellIns.shellSort2(arr3);
        System.out.print("希尔排序 gap=2");
        PrintUtil.printfArrs(arr3);


        ShellIns.shellSort2(arr4);
        System.out.print("希尔排序 gap=3");
        PrintUtil.printfArrs(arr4);



        //初始化一个斐波那契数列的数组 长度为35位
        int []fib = new int[40];
        for (int i = 0; i <fib.length ; i++) {
            fib[i] = FibonacciUtil.generateFibSeq(i);
            //System.out.println(FibonacciUtil.generateFibSeq(i));
        }
        ShellIns.shellSortFib(arr5,fib);
        System.out.print("希尔排序 gap=Fibonacci");
        PrintUtil.printfArrs(arr5);

    }


}
