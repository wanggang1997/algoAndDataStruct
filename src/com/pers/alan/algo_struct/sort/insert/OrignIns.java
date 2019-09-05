package com.pers.alan.algo_struct.sort.insert;

public class OrignIns {

    //最原始的插入排序
    public static void oriInsSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0&&arr[j-1] > arr[j]; j--) {
                arr[j] = arr[j] ^ arr[j - 1];
                arr[j - 1] = arr[j] ^ arr[j - 1];
                arr[j] = arr[j - 1] ^ arr[j];
            }
        }
    }

}
