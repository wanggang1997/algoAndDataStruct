package com.pers.algo.nographic.select;

import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {
    public static void main(String[] args) {

        int []arr = GenerateArrayUtil.generateRandomArray(100,0,100);
        PrintUtil.printfArrs(arr);
        SelectionSort.selSort(arr);
        //打印排序后的数组
        PrintUtil.printfArrs(arr);
    }
}
