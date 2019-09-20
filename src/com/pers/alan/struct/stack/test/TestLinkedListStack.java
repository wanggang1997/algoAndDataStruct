package com.pers.alan.struct.stack.test;

import com.pers.alan.struct.stack.LinkedListStack;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-06 10:08
 **/
public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack.toString());

        System.out.println("弹出栈顶元素："+linkedListStack.pop());

        System.out.println(linkedListStack.toString());

        System.out.println("压入新元素: 100");
        linkedListStack.push(100);

        System.out.println(linkedListStack.toString());
    }
}