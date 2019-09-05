package com.pers.alan.algo_struct.tree.binarysearch;

import com.pers.alan.algo_struct.heap.HeapSort;
import com.pers.alan.algo_struct.utils.PrintUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        int [] arr= {9,2,5,8,1,4,6,3,7};
        HeapSort.heapSortIndex(arr);
        PrintUtil.printfArrs(arr);

        int n = 4;
        int i = BinarySearch.binSearch(arr, n);
        System.out.println(n+"的位置是"+i );
        System.out.println(arr[i]);
    }

}
