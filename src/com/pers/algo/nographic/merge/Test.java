package com.pers.algo.nographic.merge;

import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {
    public static void main(String[] args) {
        int []arr = GenerateArrayUtil.generateRandomArray(100,0,100);
        MergeIns.mergeSort(arr);
        PrintUtil.printfArrs(arr);
    }
}
