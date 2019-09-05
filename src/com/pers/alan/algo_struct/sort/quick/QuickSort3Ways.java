package com.pers.alan.algo_struct.sort.quick;

import com.pers.alan.algo_struct.sort.insert.OptimizedIns;
import com.pers.alan.algo_struct.utils.SwapUtil;

public class QuickSort3Ways {

    public static void quickSort3Ways(int []arr){
        __quickSort(arr,0,arr.length-1);
    }

    private static void __quickSort(int[] arr, int l, int r) {
        //if (l>=r) return;
        if (r-l<15){
            OptimizedIns.optInsSort(arr, l, r);
            return;
        }

        //
        int ran=(int)(Math.random()*(r-l+1)+l);
        SwapUtil.swapByIndex(arr,l,ran);
        //
        int e = arr[l];
        //patition
        int lt = l; //arr[l+1...lt]<e
        int i =l+1;          // arr[lt+1...i)==e
        int gt = r+1;//arr[gt...r]>e
        while (i<gt){
            if (arr[i]<e){
                SwapUtil.swapByIndex(arr,i,lt+1);
                lt++;
                i++;
            }else if (arr[i]>e){
                SwapUtil.swapByIndex(arr,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        SwapUtil.swapByIndex(arr,l,lt);

        __quickSort(arr,l,lt-1);
        __quickSort(arr,gt,r);
    }



}
