package com.pers.alan.struct.linkedlist.test;

import com.pers.alan.struct.linkedlist.LinkedList;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-05 10:55
 **/
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList= new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            linkedList.addLast(i);
        }
        linkedList.add(3,9);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.toString());

        System.out.println("删除首部");
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.toString());

        System.out.println("删除尾部");
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.toString());

        System.out.println("删除全部");
        for (int i = 0; i <3 ; i++) {
            linkedList.removeLast();
        }
        System.out.println(linkedList.toString());

/*        System.out.println("测试删除异常");
        linkedList.removeFirst();*/

    }

}
