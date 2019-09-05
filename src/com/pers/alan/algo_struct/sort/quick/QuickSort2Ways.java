package com.pers.alan.algo_struct.sort.quick;


import com.pers.alan.algo_struct.sort.insert.OptimizedIns;
import com.pers.alan.algo_struct.utils.SwapUtil;

public class QuickSort2Ways {
    public static void quickSort2Ways(int[] arr){
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

        //arr[l+1...i)<=e   arr(j...r)>e
        int i=l+1,j=r;
        while (true){
            while (i<=r && arr[i]<e) i++;
            while (j>=l+1 && arr[j]>e) j--;
            if (i>j) break;
            SwapUtil.swapByIndex(arr,i,j);
            i++;
            j--;
            }
        SwapUtil.swapByIndex(arr,j,l);
        return j;
        }
}
