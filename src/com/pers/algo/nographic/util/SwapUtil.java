package com.pers.algo.nographic.util;

import java.util.Arrays;

public class SwapUtil {

    //
    public static void swapByIndex(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

/*    public static void swap(int m,int n){
        m = m ^ n;
        n = m ^ n;
        m = n ^ m;
    }*/

    public static void main(String[] args) {
        int [] arr = {3,3};
        swapByIndex(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }

}
