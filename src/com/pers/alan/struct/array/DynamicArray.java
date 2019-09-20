package com.pers.alan.struct.array;

/**
 * @program: algoAndDataStruct
 * @description: 动态数组
 * @author: wg
 * @create: 2019-09-03
 **/
public class DynamicArray<E> {


    private E[] data;
    //size>0时 != maxIndex
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        data =  (E[])new Object[capacity] ;
    }

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(E[] arr) {
        this.data =  (E[]) (new Object[arr.length]);
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /*/**
     * @title
     * @description 返回当前动态数组使用的容量
     * @author wg
     * @updateTime 2019/9/3
     * @return: int
     * @throws
     */
    public int size() {
        return size;
    }

    /*/**
     * @title
     * @description 返回当前动态数组是否为空
     * @author wg
     * @updateTime 2019/9/3
     * @return: boolean
     * @throws
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*/**
     * @title
     * @description 返回动态数组的容量大小
     * @author wg
     * @updateTime 2019/9/3
     * @return: int
     * @throws
     */
    public int getCapacity() {
        return capacity;
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @param: index
     * @param: e
     * @updateTime 2019/9/4
     * @throws
     */
    public void add(int index, E e) {

        //当数组容量达到capacity时 自动扩容
        if (size == capacity)
            resize(this.capacity<<1);

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Reqeire index>=0 and index <= size ");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //给动态数组首部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //给动态数组尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取index的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Reqeire index>=0 and index <= size ");
        return data[index];
    }

    //获取首部元素
    public E getFirst(){
        return get(0);
    }

    //获取尾部元素
    public E getLast(){
        return get(size-1);
    }

    //为index修改值
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Reqeire index>=0 and index <= size ");
        data[index] = e;
    }

    //判断动态数组中是否包含e
    public boolean contains(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //寻找动态数组中 值为e的index值
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e) )
                return i;
        }
        return -1;
    }


    /*/**
     * @title
     * @description  删除指定位置的元素e 并返回该元素
     *               !!!注意数组越界问题
     * @author wg
     * @updateTime 2019/9/4
     * @return: int
     * @throws
     */
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Reqeire index>=0 and index <= size ");

        E res = data[index];
        for (int i = index+1; i < size ; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == this.capacity>>2 && this.capacity>>1!=0)
            resize(this.capacity>>1);
        return res;
    }

    //删除动态数组首部元素
    public E removeFirst(){
        if (isEmpty())
            throw  new IllegalArgumentException("Remove failed.Array is empty.");
        else
            return remove(0);
    }

    //删除动态数组尾部元素
    public E removeLast(){
        if (isEmpty())
            throw  new IllegalArgumentException("Remove failed.Array is empty.");
        else
            return remove(size-1);
    }

    //从动态数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index!=-1)
         remove(index);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array: size: %d,capacity: %d \n", size, capacity));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    /*/**
     * @title
     * @description 自动扩容
     * @author wg
     * @updateTime 2019/9/4
     * @throws
     */
    private void resize(int capacity) {
        this.capacity = capacity;
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //根据索引交换元素的位置
    public void swap(int i, int j) {

        if (i<0||i>size || j<0||j>size)
            throw new IllegalArgumentException("The index is out of range.");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}