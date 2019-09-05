package com.pers.alan.algo_struct.heap;

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

    public static void heapSortIndex(int []arr) throws Exception {
        int len = arr.length;
        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(len);
        for (int i = 0; i < len; i++) {
            indexMaxHeap.insert(i,arr[i]);
        }
        for (int i = len-1; i >=0 ; i--) {
            arr[i] = indexMaxHeap.extractMax();
        }
    }

}
