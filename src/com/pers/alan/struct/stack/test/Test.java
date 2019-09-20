package com.pers.alan.struct.stack.test;

import com.pers.alan.algo_struct.utils.PrintUtil;
import com.pers.alan.struct.stack.ArrayStack;
import com.pers.alan.struct.stack.LinkedListStack;
import com.pers.alan.struct.stack.Stack;

import java.util.Random;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-06 10:20
 **/
public class Test {
    private static Random random = new Random();
    private static  void testQueue(Stack<Integer> s, int opCount){
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(s.getSize());
        for (int i = 0; i < opCount; i++) {
            s.pop();
        }
        System.out.println(s.getSize());
        long endTime = System.nanoTime();
        PrintUtil.printRunTime(s.getClass().getName(), startTime, endTime);
    }

    //TODO 此处有个疑问 为何大数据下的寻址操作如此耗时
    //实验得  与操作系统 jvm 程序执行顺序皆相关
    public static void main(String[] args) {
        int opCount = 10000000;
        System.out.println("--------");

         testQueue(new ArrayStack<>(),opCount);
        //System.out.println("--------");

        testQueue(new LinkedListStack<>(),opCount);
        //System.out.println("--------");
    }

}
