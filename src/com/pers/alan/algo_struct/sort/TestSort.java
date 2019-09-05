package com.pers.alan.algo_struct.sort;

import com.pers.alan.algo_struct.utils.GenerateArrayUtil;
import com.pers.alan.algo_struct.utils.PrintUtil;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-03 10:15
 **/
public class TestSort {
    public static <T> void testSortNorder(int n,Class<T>testClass) {
        int[] testArr = GenerateArrayUtil.generateRandomArray(n, 0, n);
        long startTime = System.nanoTime();

        long endTimex= System.nanoTime();
        PrintUtil.printRunTime(testClass.getSimpleName()+":随机无序,时间为", startTime, endTimex);
    }
}
