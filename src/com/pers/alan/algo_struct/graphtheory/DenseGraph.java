package com.pers.alan.algo_struct.graphtheory;

import java.util.Vector;

/**
 * @program: algoAndDataStruct
 * @description: 稠密图
 * @author: wg
 * @create: 2019-09-03 20:31
 **/
public class DenseGraph {

    private int m,n;
    private boolean isDerected;
    private Vector<Vector<Boolean>>g;

    public DenseGraph( int n, boolean isDerected) {
        this.m = 0;
        this.n = n;
        this.isDerected = isDerected;
        g= new Vector<>();
        for (int i = 0; i < n; i++) {
            Vector v = new Vector<Boolean>();
            v.add(Boolean.FALSE);
            g.add(v);
        }
    }

    public static void main(String[] args) {
        DenseGraph denseGraph = new DenseGraph(100,false);

    }
}
