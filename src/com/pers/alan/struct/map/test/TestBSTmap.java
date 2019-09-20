package com.pers.alan.struct.map.test;

import com.pers.alan.struct.map.BSTMap;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-18
 **/
public class TestBSTmap {

    public static void main(String[] args) {
        BSTMap<String,Integer> bstMap = new BSTMap<>();

        bstMap.add("a",1);
        bstMap.add("b",2);
        bstMap.add("c",3);
        bstMap.add("d",4);
        bstMap.add("e",5);

        System.out.println(bstMap.getSize());
        System.out.println(bstMap.isEmpty());
        System.out.println(bstMap);

        System.out.println(bstMap.get("d"));

        bstMap.set("d",100);

        System.out.println(bstMap.get("d"));

        bstMap.remove("d");

        System.out.println(bstMap.getSize());

        System.out.println(bstMap.toString());
    }

}
