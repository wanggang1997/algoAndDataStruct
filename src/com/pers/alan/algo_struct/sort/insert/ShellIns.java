package com.pers.alan.algo_struct.sort.insert;

public class ShellIns {


    //希尔排序
    public static void shellSort2(int []arr){
        //增量初始赋值 并不断改变增量的值
        for (int gap = arr.length/2;gap>0;gap/=2){
            //对由增量分组的值 进行直接插入排序（优化版）
            insertForShell(arr, gap);
        }
    }

    public static void shellSort3(int []arr){
        //增量初始赋值 并不断改变增量的值
        for (int gap = arr.length/2;gap>0;gap/=3){
            //对由增量分组的值 进行直接插入排序（优化版）
            insertForShell(arr, gap);
        }
    }

    public static void shellSortFib(int []arr,int []fib){
        int indexFib = 0;
        for (int i = fib.length-1;i>0;i-- ){
            if (fib[i]>arr.length/2){
                indexFib = i;
                break;
            }
        }
        for (int gap = fib[indexFib];gap>0;gap = fib[indexFib--]){
            //对由增量分组的值 进行直接插入排序（优化版）
            insertForShell(arr, gap);
            if (gap==1) break;
        }
    }

    private static void insertForShell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {

            int key = arr[i];
            int j;
            for (j = i - gap; j >= 0 && key < arr[j]; j -= gap) {
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = key;
        }
    }
}
