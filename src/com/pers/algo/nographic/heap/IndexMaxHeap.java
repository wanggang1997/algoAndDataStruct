package com.pers.algo.nographic.heap;

import com.pers.algo.nographic.util.SwapUtil;

public class IndexMaxHeap {
    //
    private int[] data;
    //
    private int[] indexes;
    //
    private int[] reverse;
    private int capacity;
    private int count;

    //构造函数
    public IndexMaxHeap(int capacity) {
        //内部由1开始 外部由0开始
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    //外部从0开始
    public void insert(int i, int e) throws Exception {
        if (count + 1 > capacity) throw new Exception("当前堆到达最大值");
        if (i + 1 < 0 && i + 1 > capacity) throw new Exception("当前反向索引堆堆到达最大值");
        i += 1;

        //初始化
        data[i] = e;
        indexes[count+1] = i;
        reverse[i] = count+1;

        count ++;
        __shiftup(count);
    }

    //取出堆中最大值
    public int extractMax() throws Exception {
        if (count <= 0) throw new Exception("当前堆为空");
        int res = data[indexes[1]];
        SwapUtil.swapByIndex(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        __shiftdown(1);
        return res;
    }

    //取出堆中最大索引
    public int extactIndexMax() throws Exception {
        if (count <= 0) throw new Exception("当前堆为空");
        int res = indexes[1] - 1;
        SwapUtil.swapByIndex(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        __shiftdown(1);
        return res;
    }

    //根据索引取出一个值
    public int getVal(int i) throws Exception {
        if (!contains(i)) throw new Exception("无该值");
        return data[i - 1];
    }
    //
    private void __shiftup(int k) {
        while (k > 1 && data[indexes[k]] > data[indexes[k / 2]]) {
            //索引堆随数据变化而维护其定义
            SwapUtil.swapByIndex(indexes, k, k / 2);
            //维护反向数组的定义
            reverse[indexes[k]] = k;
            reverse[indexes[k / 2]] = k / 2;
            k /= 2;
        }
    }

    //
    private void __shiftdown(int k) {
        while (k * 2 <= count) {
            int j = k * 2;
            if (j + 1 <= count && data[indexes[j]] < data[indexes[j + 1]])
                j = j + 1;
            if (data[indexes[k]] > data[indexes[j]])
                break;
            SwapUtil.swapByIndex(indexes, j, k);
            reverse[indexes[j]] = j;
            reverse[indexes[k]] = k;
            k = j;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }



    //改变堆中的一个值 e:新插入的值
    public void change(int i, int e) throws Exception {
        if (!contains(i)) throw new Exception("无该值");
        i += 1;
        data[i] = e;
/*        for (int j = 1; j <= count ; j++) {
            //寻找此刻i对应的索引位置 并将j进行updown 以维护索引堆
            if (indexes[j] == i){
                __shiftup(j);
                __shiftdown(j);
                return;
            }
        }*/
        int j = reverse[i];
        __shiftup(j);
        __shiftdown(j);
    }

    //判断包含值为i的索引 包含：true
    private boolean contains(int i) {
        if( i+1>0 && i + 1  < capacity )
            return reverse[i]!=0;
        return false;
    }


}
