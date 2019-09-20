package com.pers.alan.struct.heap;

import com.pers.alan.struct.array.DynamicArray;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * @program: algoAndDataStruct
 * @description: 堆的数组实现 此处使用自定义的动态数组 根节点从数组0项开始
 * @author: wg
 * @create: 2019-09-18
 **/
public class MaxHeap<E extends Comparable<E>> {

    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        data = new DynamicArray<>();
    }

    //heapify
    public  MaxHeap(E[] arr){
        data = new DynamicArray<>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            shiftDown(i);
        }
    }

    //判断堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //获得堆当前大小
    public int getSize() {
        return data.size();
    }

    //返回完全二叉树的数组表示中 一个索引所表示元素的父亲的索引
    private int parent(int index) {
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中 一个索引所表示元素的左孩子的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中 一个索引所表示元素的右孩子的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.size() - 1);
    }

    //堆的shiftUp操作
    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            //如果k所在元素小于k的parent所在元素
            // 则进行一个交换操作
            // 直到k所在元素寻找到合适的位置
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    //取出堆中最大元素(最大堆的由来)
    public E extractMax(){
        E res = findMax();

        data.swap(0,data.size()-1);
        data.removeLast();
        shiftDown(0);

        return res;
    }
    //获取堆中最大元素
    public E findMax(){
        if (data.size()==0)
            throw new IllegalArgumentException("Can extractMax,heap is empty.");
        return data.get(0);
    }

    //堆的shiftDown操作
    private void shiftDown(int k){

        while (leftChild(k) < data.size()){
            int j = leftChild(k);
            if (j+1 <data.size() && data.get(j).compareTo(data.get(j+1))<0)
                j = rightChild(k);
            //j：k的左右孩子中的较大元素

            //k若小于后代元素 循环才应继续下去
            //若j（孩子）小于或等于 父元素（k） break
            if (data.get(j).compareTo(data.get(k)) <=0)
                break;

            data.swap(j,k);
            //注意k才是循环的中间变量
            k = j;
        }

    }

    //取出最大元素 将其替换为元素e
    public E replace(E e){
        E res = findMax();
        data.set(0,e);
        shiftDown(0);
        return res;
    }


}
