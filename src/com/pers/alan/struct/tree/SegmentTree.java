package com.pers.alan.struct.tree;

/**
 * @program: algoAndDataStruct
 * @description: 线段树： 完全二叉树的数组实现
 * @author: wg
 * @create: 2019-09-19
 **/
public class SegmentTree<E> {

    //实际数组元素
    private E[] data;
    //线段树存储
    private E[] tree;
    //传入用户自定义的Merger
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.data = (E[]) new Object[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length - 1);
    }


    //返回[queryL,queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /*/*
     * @title
     * @description 递归查询 treeIndex[]
     * @author wg
     * @param: treeIndex
     * @param: l
     * @param: r
     * @param: queryL
     * @param: queryR
     * @updateTime 2019/9/19
     * @return: E
     * @throws
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //当l==queryL && r==queryR时
        //其父节点刚好为预查询的值
        if (l==queryL && r==queryR)
            return tree[treeIndex];

        int mid = l+(r-l)/2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if (queryL >= mid+1)
            //此时只需要在mid及其右方寻找目标区间
            return query(rightChildIndex,mid+1,r,queryL,queryR);
        if (queryR<= mid)
            //此时只需要在mid左方寻找目标区间
            return query(leftChildIndex,l,mid,queryL,queryR);

        //此时在l到r之间寻找
        //注意 每次递归后 左边界与右边界可能会变化
        //本质是分割为更小的问题
        E leftResult = query(leftChildIndex,l,mid,queryL,mid);
        E rightResult = query(rightChildIndex,mid+1,r,mid+1,queryR);

        return merger.merge(leftResult,rightResult);
    }

    /*/*
     * @title
     * @description 在treeIndex的位置创建 区间[l,r]的线段树
     *              递归操作 对树更简单
     * @author wg
     * @param: treeIndex
     * @param: l
     * @param: r
     * @updateTime 2019/9/19
     * @throws
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            //处理递归到底
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        /*
         * int mid = (l+r)/2;
         * l+r有越界风险（超出int定义的范围）
         */
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        //真正的线段树节点的定义 应当由用户抉择
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    //将index位置的值设置为e
    public void set(int index,E e){
        if (index<0 || index>=data.length)
            throw new IllegalArgumentException("Index is out of range.");
        data[index]=e;

        set(0,0,data.length,index,e);
    }
    /*/*
     * @title
     * @description 递归设置index的值 并返回给上层
     * @description 注意理解递归的边界条件 以及区间树的每一个节点定义
     * @author wg
     * @param: treeIndex
     * @param: l
     * @param: r
     * @param: index
     * @param: e
     * @updateTime 2019/9/20
     * @throws
     */
    private void set(int treeIndex,int l,int r,int index ,E e){
        //注意递归终止条件
        if (l==r){
            tree[treeIndex]=e;
            return;
        }

        int mid = l +(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index>=mid+1)
            set(rightTreeIndex,mid+1,r,index,e);
        else //index <=mid
            set(leftTreeIndex,l,mid,index,e);

        //递归修改后 应当从下至上的返回每一层的值 给父节点
        //以便维护区间树的定义

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("The index is out of range.");

        return data[index];
    }

    //返回完全二叉树的数组表示中 左孩子的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中 右孩子的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
