package com.pers.alan.algo_struct.union;

/**
 * @program: algoAndDataStruct
 * @description: 快合并 慢查询
 * @author: wg
 * @create: 2019-09-03 14:21
 **/
public class UnionFind2 {
    private int[] parent;
    private int count;

    public UnionFind2() {
    }

    public UnionFind2(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        while (i != parent[i])
            i = parent[i];
        return i;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }

}
