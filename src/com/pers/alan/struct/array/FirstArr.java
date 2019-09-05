package com.pers.alan.struct.array;

import java.util.Iterator;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-03 22:40
 **/
public class FirstArr {

    public static void main(String[] args) {
        int []arr = new int[10];
        for (int i = 0; i <10 ; i++) {
            arr[i] = i;
        }

        for (int i = 0; i <10 ; i++) {
            System.out.println(arr[i]);;
        }

        System.out.println("-------");

        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("-------");

    }
}
