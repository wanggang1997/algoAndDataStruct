package com.pers.alan.struct.array;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 10:40
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println("第一个数组");
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



        System.out.println("二次封装的动态数组");
        DynamicArray<Integer> darr = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            darr.addLast(i);
        }
        System.out.println(darr.toString()+"\n");

        System.out.println("添加首部5");
        darr.addFirst(5);
        System.out.println(darr.toString()+"\n");

        System.out.println("添加尾部7");
        darr.addLast(7);
        System.out.println(darr.toString()+"\n");

        System.out.println("得到0的元素");
        System.out.println(darr.get(0));

        darr.set(0,9);
        System.out.println(darr.toString()+"\n");

        System.out.println("删除索引2的e："+darr.remove(2));
        System.out.println(darr.toString()+"\n");

        System.out.println("删除首部"+darr.removeFirst());
        System.out.println(darr.toString()+"\n");

        System.out.println("删除尾部"+darr.removeLast());
        System.out.println(darr.toString()+"\n");

        System.out.println("移除元素9");
        darr.removeElement(9);
        System.out.println(darr.toString()+"\n");

        System.out.println("插入13个新的元素");
        for (int i = 0; i < 13; i++) {
            darr.addLast(i);
        }
        System.out.println(darr.toString()+"\n");
    }
}
