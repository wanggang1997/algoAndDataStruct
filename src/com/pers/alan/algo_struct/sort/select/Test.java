package com.pers.alan.algo_struct.sort.select;

import com.pers.alan.algo_struct.utils.GenerateArrayUtil;
import com.pers.alan.algo_struct.utils.PrintUtil;

public class Test {
    public static void main(String[] args) {

        int []arr = GenerateArrayUtil.generateRandomArray(100,0,100);
        PrintUtil.printfArrs(arr);
        SelectionSort.selSort(arr);
        //打印排序后的数组
        PrintUtil.printfArrs(arr);
    }
}
