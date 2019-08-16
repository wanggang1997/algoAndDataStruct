package com.pers.algo.nographic.quick;

import com.pers.algo.nographic.util.GenerateArrayUtil;
import com.pers.algo.nographic.util.PrintUtil;

public class Test {

    public static void main(String[] args) {
        int[] arr = GenerateArrayUtil.generateRandomArray(10, 0, 10);
        PrintUtil.printfArrs(arr);
        //
        QuickSort3Ways.quickSort3Ways(arr);
        PrintUtil.printfArrs(arr);
    }

}
