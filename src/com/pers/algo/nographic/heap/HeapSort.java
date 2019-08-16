package com.pers.algo.nographic.heap;

public class HeapSort {

    public static void heapSort1(int []arr){
        int len = arr.length;
        MaxHeap maxHeap = new MaxHeap(len);
        for (int i = 0; i < len; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = len-1; i >=0 ; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
    public static void heapSort2(int []arr){
        int len = arr.length;
        MaxHeap maxHeap = new MaxHeap(arr,len);
        for (int i = len-1; i >=0 ; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }



}
