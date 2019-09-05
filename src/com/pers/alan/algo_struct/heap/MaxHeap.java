package com.pers.alan.algo_struct.heap;

import com.pers.alan.algo_struct.utils.SwapUtil;

public class MaxHeap {

    //最大堆 节点从1开始
    private int [] data;
    private int capacity;
    private int count;

    //
    private void shiftUp(int k) {
        while (k>1&&data[k/2]<data[k]){
            SwapUtil.swapByIndex(data,k/2,k);
            k=k/2;
        }
    }
    //
    private void shiftDown(int k) {
        while (k*2<=count){
            int j = k*2 ;
            if (j+1 <=count && data[j+1]>data[j])
                j+=1;

            if (data[k]>data[j])
                break;

            SwapUtil.swapByIndex(data,k,j);
            k=j;
        }
    }

    //构造函数
    public MaxHeap(int capacity) {
        count=0;
        this.capacity=capacity;
        System.out.println("当前cap"+capacity);
        data = new int[this.capacity+1];
    }

    //heapify
    public MaxHeap(int []arr,int n){
        data = new int[n+1];
        count = n;
        for (int i = 0; i <n ; i++) {
            data[i+1] = arr[i];
        }
        for (int i = count/2; i >0 ; i--) {
            shiftDown(i);
        }

    }


    public int capacity(){
        return this.capacity;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public void insert(int e){
        //  0-capacity
        if (count <= this.capacity-1){
            data[++count] = e;
            shiftUp(count);

        }
    }

    public int extractMax(){

        int res = data[1];
        SwapUtil.swapByIndex(data,1,count);
        count--;
        shiftDown(1);
        return res;
    }

    //打印堆中数据
    public void printMaxHeap(){
        for (int i = 1; i <=count ; i++) {
            System.out.print(data[i]+" ");
        }
    }

}
