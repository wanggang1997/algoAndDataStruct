package com.pers.alan.algo_struct.sort.quick;

import com.pers.alan.algo_struct.utils.GenerateArrayUtil;
import com.pers.alan.algo_struct.utils.PrintUtil;

public class Test {

    public static void main(String[] args) {
        int[] arr = GenerateArrayUtil.generateRandomArray(10, 0, 10);
        PrintUtil.printfArrs(arr);
        //
        QuickSort3Ways.quickSort3Ways(arr);
        PrintUtil.printfArrs(arr);
    }

}
