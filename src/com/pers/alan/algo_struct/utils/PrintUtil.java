package com.pers.alan.algo_struct.utils;

import java.util.Arrays;

public class PrintUtil {

    //打印算法执行时间 纳秒级
    public static void printRunTime(String algoName,long startTime,long endTime){
        float excTime=(float)(endTime-startTime)/1000000000L;
        System.out.println(algoName+"的执行时间为："+excTime+"s");
        System.out.println();
    }

    //格式化数组输出
    public static void printfArrs(int []arr){
        System.out.println(Arrays.toString(arr));
    }

}
