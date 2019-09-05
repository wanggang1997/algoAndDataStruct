package com.pers.alan.algo_struct.sort.quick;


import com.pers.alan.algo_struct.sort.insert.OptimizedIns;
import com.pers.alan.algo_struct.utils.SwapUtil;

public class QuickSort1Way {

    public static void quickSort1Way(int[] arr){

        __quickSort(arr,0,arr.length-1);

    }
    private static void __quickSort(int[]arr,int l,int r){
            //if (l>=r) return;
             if (r-l<15){
                 OptimizedIns.optInsSort(arr, l, r);
                 return;
             }

            int p = __patition(arr,l,r);
            __quickSort(arr,l,p-1);
            __quickSort(arr,p+1,r);
    }
    private static  int __patition(int[]arr,int l, int r){
        //
        int ran=(int)(Math.random()*(r-l+1)+l);
        SwapUtil.swapByIndex(arr,l,ran);

        //标志对象
        int e = arr[l];

        //arr[l+1...j]<e   arr[j+1...i)>e
        int j =l;
        for (int i = j+1;i<=r;i++){
            if (arr[i]<e) {
                SwapUtil.swapByIndex(arr, i, j + 1);
                j++;
            }
        }
        SwapUtil.swapByIndex(arr,l,j);
        return j;
    }
}
