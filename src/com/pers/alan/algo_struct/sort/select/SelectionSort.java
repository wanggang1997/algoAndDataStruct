package com.pers.alan.algo_struct.sort.select;

public class SelectionSort {

    public static void selSort(int[] arr) {

        //选择
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (arr[minIndex] != arr[i]) {
/*                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;*/

                //
                arr[minIndex]=arr[minIndex]^arr[i];

                //i = minIndex ^ i ^ i 即 minIndex的值
                arr[i]=arr[minIndex]^arr[i];

                //== minIndex ^ i ^ minIndex 即 i的值
                arr[minIndex]=arr[i]^arr[minIndex];
            }
        }

    }


}
