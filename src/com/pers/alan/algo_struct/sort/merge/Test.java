package com.pers.alan.algo_struct.sort.merge;

import com.pers.alan.algo_struct.utils.GenerateArrayUtil;
import com.pers.alan.algo_struct.utils.PrintUtil;

public class Test {
    public static void main(String[] args) {
        int []arr = GenerateArrayUtil.generateRandomArray(100,0,100);
        MergeIns.mergeSort(arr);
        PrintUtil.printfArrs(arr);
    }
}
