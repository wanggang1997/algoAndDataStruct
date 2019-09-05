package com.pers.alan.algo_struct.sort.merge;

import com.pers.alan.algo_struct.sort.insert.OptimizedIns;

public class MergeIns {

    //自上而下的归并排序 对外接口
    public static void mergeSort(int []arr){
        __mergeSort(arr,0,arr.length-1);
    }

    //arr[l...r] 进行归并排序
    private static void __mergeSort(int[] arr, int l, int r) {
/*        if (l>=r)
            return;*/

        //用插入排序优化
        if (r-l<=15){
            OptimizedIns.optInsSort(arr,l,r);
            return;
        }

        int mid = (l+r)/2;
        __mergeSort(arr, l, mid);
        __mergeSort(arr,mid+1,r);
        //优化
        if (arr[mid]>arr[mid+1])
            __merge(arr,l,mid,r);
    }

    //arr[l...mid]   arr[mid+1...r]进行归并操作
    private static void __merge(int[] arr, int l, int mid, int r) {
        //辅助空间
       int []aux = new int[r-l+1];
        for (int i = l; i <=r ; i++) {
            aux[i-l] = arr[i];
        }
        int i=l, j=mid+1;

        //从左臂 到 右臂 依次赋值
        for (int k = l; k <= r; k++) {

            if (i>mid){                 //任意数组中无值 都直接将另一个数组中的值插入
                arr[k] = aux[j-l];
                j++;
            }else if(j>r){
                arr[k] = aux[i-l];
                i++;
            }else if (aux[i-l]<aux[j-l]){ //仅当两个数组都有值时 才比较并插入数组中
                    arr[k] = aux[i-l];
                    i ++;
            }else {
                arr[k] = aux[j-l];
                j++;
            }

        }

    }


}
