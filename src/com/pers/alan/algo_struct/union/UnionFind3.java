package com.pers.alan.algo_struct.union;

/**
 * @program: algoAndDataStruct
 * @description: 并查集 快union 快查询
 * @author: wg
 * @create: 2019-09-03 14:46
 **/
public class UnionFind3 {

    private int[] parent;
    private int[] weight;
    private int count;

    public UnionFind3() {
    }

    public UnionFind3(int n) {
        parent = new int[n];
        weight = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i]=1;
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

        if (pRoot == qRoot)
            return;

        if (weight[pRoot]<weight[qRoot]){
            parent[pRoot] = qRoot;
            weight[qRoot]+=weight[pRoot];
        }else {
            parent[qRoot] = pRoot;
            weight[pRoot]+=weight[qRoot];
        }
    }

}
