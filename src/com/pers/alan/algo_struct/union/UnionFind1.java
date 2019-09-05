package com.pers.alan.algo_struct.union;

/**
 * @program: algoAndDataStruct
 * @description: 并查集的第一种实现【easy】 快查询 慢合并
 * @author: wg
 * @create: 2019-09-03 09:57
 **/
public class UnionFind1 {
     //每一个元素对应相应的组的值
     private int[] id;
     //该并查集中拥有的元素数量
     private int count;

     public UnionFind1() {
     }

     //构造函数 传入n个数据到并查集中
     public UnionFind1(int n) {
         id = new int[n];
         count = n;
         for (int i = 0; i < n; i++) {
             id[i] = i;
         }
     }

     //
     public int find(int i) {
         return id[i];
     }

     //
     public boolean isConnected(int p, int q) {
         return find(q) == find(p);
     }

     //
     public void unionElement(int p, int q) {
         int pi = find(p);
         int qi = find(q);
         if (pi != qi) {
             for (int i = 0; i < count; i++) {
                 if (id[i] == pi)
                     id[i] = qi;
             }
         }
     }

}
