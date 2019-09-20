package com.pers.alan.algo_thinking.recursion;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-06 20:47
 **/
public class SUM {

    public static int sum(int []arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr, int i) {
        if (i == arr.length)
            return 0;
        return arr[i] + sum(arr,i+1);
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,2,3,4,5}));
    }
}
