package com.pers.alan.algo_struct.tree.binarysearch;

public class BinarySearch {

    //arr 为有序数组
    public static int binSearch(int []arr,int target){
        int l =0;
        int r = arr.length-1;
        //在[l,r]中寻找target
        while (l<=r){
            //int mid = (l+r)/2; 存在int相加越界问题
            int mid = l + (r-l)/2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid]>target)
                r = mid - 1;
            else
                l = mid+1;
        }
        return -1;
    }

}
