package com.pers.algo.nographic.heap;

import com.pers.algo.nographic.util.SwapUtil;

public class IndexMaxHeap {

    private int[] data;
    private int capacity;
    private int count;
    private int[] index;

    //
    private void __shiftup(int k) {
        while (k > 1 && data[index[k]] > data[index[k / 2]]) {
            SwapUtil.swapByIndex(index, k, k / 2);
            k /= 2;
        }
    }

    //
    private void __shiftdown(int k) {
        while (k * 2  <= count) {
            int j = k * 2 ;
            if (j+1<=count && data[index[j]] < data[index[j + 1]])
                j = j + 1;

            if (data[index[k]] > data[index[j]])
                break;

            SwapUtil.swapByIndex(index, j, k);
            k = j;
        }
    }

    public IndexMaxHeap(int capacity) {
        this.capacity = capacity;
        //内部由1开始 外部由0开始
        data = new int[this.capacity + 1];
        index = new int[this.capacity + 1];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //外部从0开始
    public void insert(int i, int e) {
        if (count + 1 > capacity) return;
        if (i + 1 < 0 && i + 1 > capacity) return;
        i += 1;

        data[i] = e;
        index[++count] = i;
        __shiftup(count);
    }

    //取出堆中最大值
    public int extractMax() throws Exception {
        if (count <= 0) throw new Exception("当前堆为空");

        int res = data[index[1]];
        SwapUtil.swapByIndex(index, index[1], index[count]);
        count--;
        __shiftdown(1);
        return res;
    }

    //取出堆中最大索引
    public int extactIndexMax() throws Exception {
        if (count <= 0) throw new Exception("当前堆为空");
        int res = index[1]-1;
        SwapUtil.swapByIndex(index,1,count);
        count--;
        __shiftdown(1);
        return res;
    }

    //根据索引取出一个值
    public int getVal (int i){
        return data[i-1];
    }

    //改变堆中的一个值
    


}
