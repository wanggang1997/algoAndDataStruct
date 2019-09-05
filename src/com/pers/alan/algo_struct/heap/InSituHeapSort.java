package com.pers.alan.algo_struct.heap;

import com.pers.alan.algo_struct.utils.SwapUtil;

public class InSituHeapSort {

    public static void insituHeapSort(int []arr){
        int len = arr.length;
        for (int i = (len-1)/2; i >=0 ; i--) {
            __shiftDown(arr,i,len);
        }

        for (int i = len-1; i >0 ; i--) {
            SwapUtil.swapByIndex(arr,0,i);
            __shiftDown(arr,0,i);
        }
    }
    private static void __shiftDown(int []arr,int k,int len) {

        while (k*2+1<len){
                int j = k*2+1;
                if (j+1<len && arr[j]< arr[j+1])
                    j+=1;

                if (arr[k]>arr[j])
                    break;

                SwapUtil.swapByIndex(arr,k,j);
                k=j;
        }
    }

}
