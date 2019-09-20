package com.pers.alan.struct.map.test;

import com.pers.alan.struct.linkedlist.LinkedList;
import com.pers.alan.struct.map.LinkedListMap;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-17
 **/
public class TestLinkedListMap {


    public static void main(String[] args) {

        LinkedListMap<String,Integer>linkedListMap = new LinkedListMap<>();
        linkedListMap.add("a",1);
        linkedListMap.add("b",2);
        linkedListMap.add("c",3);
        linkedListMap.add("d",4);
        linkedListMap.add("e",5);

        System.out.println(linkedListMap.getSize());
        System.out.println(linkedListMap.isEmpty());

        System.out.println(linkedListMap.get("d"));

        linkedListMap.set("d",100);

        System.out.println(linkedListMap.get("d"));

        linkedListMap.remove("d");

        System.out.println(linkedListMap.getSize());

        System.out.println(linkedListMap.toString());
    }


}
