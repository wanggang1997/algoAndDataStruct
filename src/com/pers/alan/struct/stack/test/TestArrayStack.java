package com.pers.alan.struct.stack.test;

import com.pers.alan.struct.stack.ArrayStack;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 17:30
 **/
public class TestArrayStack {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());

        System.out.println("弹出栈顶元素");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());

        System.out.println("压入一个元素：100");
        arrayStack.push(100);
        System.out.println(arrayStack.toString());
        System.out.println("获取栈顶元素："+arrayStack.peek());
    }


}
