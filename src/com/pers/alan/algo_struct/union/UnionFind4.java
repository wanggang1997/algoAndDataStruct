package com.pers.alan.algo_struct.union;

/**
 * @program: algoAndDataStruct
 * @description: 快union 快查询 基于高度（秩）
 * @author: wg
 * @create: 2019-09-03 15:03
 **/
public class UnionFind4 {


    private int[] parent;
    private int[] height;
    int count;


    public UnionFind4(int n) {
        this.count = n;
        this.parent = new int[n];
        this.height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i]=1;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

       if (pRoot == qRoot)
           return;
        if (height[pRoot]> height[qRoot]){
            parent[qRoot] = pRoot;
        }
        else if (height[pRoot]< height[qRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[pRoot] = qRoot;
            height[qRoot]+=1;
        }
    }

}
