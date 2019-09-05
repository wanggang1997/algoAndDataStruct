package com.pers.alan.algo_struct.sort.insert;

public class OptimizedIns {

    //优化后的插入排序
    public static void optInsSort(int[]arr){
        for (int i = 1; i <arr.length ; i++) {
            int key = arr[i];
            int j;
            for ( j = i; j > 0 &&arr[j-1] > key; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = key;
        }
    }

    //从l到r范围内的插入排序
    public static void optInsSort(int[]arr,int l,int r){
        for (int i = l+1; i <=r ; i++) {
            int key = arr[i];
            int j;
            for ( j = i; j > l &&arr[j-1] > key; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = key;
        }
    }

}
