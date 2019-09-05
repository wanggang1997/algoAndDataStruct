package com.pers.alan.algo_struct.utils;

public class GenerateArrayUtil {

    //生成n个以beginNum到endNum范围随机整数的整型数组
    public static int[] generateRandomArray(int n,int beginNum,int endNum){
        int []arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = (int)(Math.random()*(endNum-beginNum+1)+beginNum);
        }
        return arr;
    }

    //数组拷贝
    public static int []copyArray(int []arr){
        /*System.arraycopy();*/
        int [] arrN = new int[arr.length];
        for (int i = 0; i <arrN.length ; i++) {
            arrN[i] = arr[i];
        }
        return  arrN;
    }

    //生成近乎有序数组
    public static int []generateNearlyOrderedArray(int n,int unorderN){
        int []arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =i;
        }
        for (int i = 0; i < unorderN; i++) {
            int j = (int)(Math.random()*(n));
            int k = (int)(Math.random()*(n));
            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
        }
        return arr;
    }

}
