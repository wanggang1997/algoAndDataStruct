package com.pers.alan.algo_struct.union;

/**
 * @program: algoAndDataStruct
 * @description: 并查集 路径压缩 循环实现
 * @author: wg
 * @create: 2019-09-03 16:03
 **/
public class UnionFind5 {

    private int[] parent;
    private int[] height;
    int count;


    public UnionFind5(int n) {
        this.count = n;
        this.parent = new int[n];
        this.height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i]=1;
        }
    }

    public int find(int p) {
        assert( p >= 0 && p < count );

        while (p != parent[p]) {
            //压缩路径
            parent[p] = parent[parent[p]];
            p=parent[p];
        }
        return p;

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
