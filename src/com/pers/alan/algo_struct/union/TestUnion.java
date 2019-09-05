package com.pers.alan.algo_struct.union;

import com.pers.alan.algo_struct.utils.PrintUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-03 10:08
 **/
public class TestUnion {
    private static Random random = new Random();
    public static <T> void testUn(int n,Class<? extends Object>testClass) throws Exception {
        Method [] methods = testClass.getMethods();
        Method unionElement = testClass.getMethod("unionElement",int.class,int.class);
        Method isConnected = testClass.getMethod("isConnected",int.class,int.class);
        Constructor<?> cons = testClass.getConstructor(int.class);
        T t = (T) cons.newInstance(n);

        long startTime = System.nanoTime();
        for (int i = 0; i < n ; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            unionElement.invoke(t,a,b);
        }
        for (int i = 0; i < n ; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            isConnected.invoke(t,a,b);
        }
        long endTime = System.nanoTime();
        PrintUtil.printRunTime(testClass.getSimpleName(), startTime, endTime);
    }

    public static void main(String[] args) throws Exception {
/*        UnionFind1 unionFind1 = new UnionFind1(10);
        System.out.println(unionFind1.isConnected(1,2));
        unionFind1.unionElement(1,2);
        System.out.println(unionFind1.find(1));
        System.out.println(unionFind1.find(2));
        System.out.println(unionFind1.isConnected(1,2));*/
        //testUn(100000, UnionFind1.class);
        //testUn(100000, UnionFind2.class);
        testUn(10000000, UnionFind3.class);
        testUn(10000000, UnionFind4.class);
        testUn(10000000, UnionFind5.class);
        testUn(10000000, UnionFind6.class);

    }
}
